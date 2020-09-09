package com.model;


public class SimpleMessage {
    public SimpleMessage(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleMessage message = (SimpleMessage) o;

        return text != null ? text.equals(message.text) : message.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    private String text;

    public String getText() {
        return text;
    }
}
