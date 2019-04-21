package com.lzh.javaclass;



public class Main {

    public final static String TopicName = "topicTest";

    public static void main(String[] args) throws Exception {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        for (int i = 0; i < 3; i++) {
            // 将一串字符串 "Message Content"转为byte数组并赋给data引用
            byte[] data = ("Message Content " + i).getBytes();
            Message message = producer.createBytesMessageToTopic(TopicName, data);
            //将message通过producer对象的send方法，发送出去
            // *************第一处 开始 *****************
            producer.send(message);
            // *************第一处 结束 *****************
        }
        // 绑定consumer对应的topic名字
        consumer.attachQueue("1", TopicName);

        // 遍历该consumer订阅的topic中的所有消息
        while (consumer.poll() != null);

    }
}

class Message {
    private String topic;
    private String content;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Message的构造函数，将参数赋给成员变量
    public Message(String topic, String content) {
        // **********第二处 开始**********
        this.content = content;
        this.topic = topic;

        // **********第二处 结束**********
    }

}

class Producer {
    public Message createBytesMessageToTopic(String topic, byte[] body) {
        // 将传入的body字节数组转成String类型，并且和传入的topic一起生成一个Message对象msg，并返回
        // **********第三处 开始************
        Message msg = new Message(topic,new String(body));
        return msg;
        // **********第三处 结束************
    }

    //每次执行发送一个message
    public void send(Message msg) {
        // 具体的实现发送消息的操作，由Store类中push方法执行
        Store.store.push(msg);
    }
}

class Consumer {
    String topic;
    String queue;

    public void attachQueue(String queueName, String topicName) throws Exception {
        if (queue != null) {
            throw new Exception("只允许绑定一次");
        }
        // 将消费者与queue和订阅的topic进行绑定
        // **********第四处 开始************
        queue = queueName;
        topic = topicName;

        // **********第四处 结束************
    }

    // 每次消费读取一个message
    public Message poll() {
        Message re = null;
        // 具体的实现拉消息的操作，由Store类中pull方法执行
        re = Store.store.pull(queue, topic);
        return re;
    }
}

class Store {
    // 保证共用一个Store对象来访问String数组
    static final Store store = new Store();
    //声明了一个长度位3的字符串数组，用来存放message中的content内容
    String[] topics = new String[3];
    int pushIndex = 0;
    int pullIndex = 0;

    //每次只push一条消息
    public void push(Message msg) {
        if (msg == null || pushIndex >= topics.length) {
            return;
        }
        String topic = msg.getTopic();
        //找到指定的topic才能定位发送，这里只有一个topic类型，涉及多个topic类型时就需要做区分
        if (topic.equals(Main.TopicName)) {
            //获取msg的content内容，将它依此赋值到topics数组，注意index的操作
            // **********第五处 开始************
            pushIndex++;
            topics[pushIndex-1] = msg.getContent();


            // **********第五处 结束************
            System.out.println("存储了消息:" + msg.getContent());
        }
    }
    //每次只从String数组中pull一条msg，并返回
    public Message pull(String queue, String topic) {
        if (pullIndex >= topics.length) {
            System.out.println("已读取完该topic所有消息");
            return null;
        }
        // 找到指定的topic数组
        if (topic.equals(Main.TopicName)) {
            // 传入topic并且依此遍历String数组中获取的内容，每次构造生成一个新的Message对象
            // **********第六处 开始************
            pullIndex++;
            Message msg = new Message(topic,topics[pullIndex-1]);

            // **********第六处 结束************
            System.out.println("读取到消息:" + msg.getContent());
            return msg;
        } else {
            System.out.println("找不到该topic");
            return null;
        }
    }
}
