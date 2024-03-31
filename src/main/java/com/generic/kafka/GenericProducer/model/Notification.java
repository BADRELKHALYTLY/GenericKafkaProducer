package com.generic.kafka.GenericProducer.model;

public class Notification<T> {

    private String className;

    private T item;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
