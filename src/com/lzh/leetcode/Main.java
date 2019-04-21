package com.lzh.leetcode;

import java.util.HashMap;
import java.util.Set;

public class Main{

    public static void main(String[] args) {
        byte[] body = "this is body".getBytes();
        KeyValue keyValue = new KeyValue();
        keyValue.put("MESSAGE_ID", 123456);
        keyValue.put("TOPIC", "Java");
        keyValue.put("BORN_TIMESTAMP", 1234567890123457890l);
        keyValue.put("PI", 3.1415926535897932384626433832795d);
        ByteMessage byteMessage = new ByteMessage(body);
        byteMessage.setHeaders(keyValue);
        System.out.println(byteMessage.headers().getInt("MESSAGE_ID"));
        System.out.println(byteMessage.headers().getLong("BORN_TIMESTAMP"));
        System.out.println(byteMessage.headers().getDouble("PI"));
        System.out.println(byteMessage.headers().getString("TOPIC"));
    }

}
//消息的实现
class ByteMessage {

    private KeyValue headers = new KeyValue();
    private byte[] body;

    public void setHeaders(KeyValue headers) {
        this.headers = headers;
    }

    public ByteMessage(byte[] body) {
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public KeyValue headers() {
        return headers;
    }

    public ByteMessage putHeaders(String key, int value) {
        //********** 第一处 开始 **********
        headers.put(key,value);
        //********** 第一处 结束 **********
        return this;
    }

    public ByteMessage putHeaders(String key, long value) {
        headers.put(key, value);
        return this;
    }

    public ByteMessage putHeaders(String key, double value) {
        headers.put(key, value);
        return this;
    }

    public ByteMessage putHeaders(String key, String value) {
        headers.put(key, value);
        return this;
    }

}


//一个Key-Value的实现类
class KeyValue {
    private final HashMap<String, Object> kvs = new HashMap<>();

    public Object getObj(String key) {
        return kvs.get(key);
    }

    public HashMap<String, Object> getMap() {
        return kvs;
    }

    public KeyValue put(String key, int value) {
        kvs.put(key, value);
        return this;
    }

    public KeyValue put(String key, long value) {
        kvs.put(key, value);
        return this;
    }

    public KeyValue put(String key, double value) {
        //********** 第二处 开始 **********
        kvs.put(key,value);
        //********** 第二处 结束 **********
        return this;
    }

    public KeyValue put(String key, String value) {
        kvs.put(key, value);
        return this;
    }

    public int getInt(String key) {
        return (Integer) kvs.getOrDefault(key, 0);
    }

    public long getLong(String key) {
        //********** 第三处 开始 **********
        return (long) kvs.getOrDefault(key,0);
        //********** 第三处 结束 **********
    }

    public double getDouble(String key) {
        return (Double) kvs.getOrDefault(key, 0.0d);
    }

    public String getString(String key) {
        return (String) kvs.getOrDefault(key, null);
    }

    public Set<String> keySet() {
        return kvs.keySet();
    }

    public boolean containsKey(String key) {
        return kvs.containsKey(key);
    }
}

