package com.example.demo;

public class HelloWorld {
    private String message;

    public void getMessage() {
        System.out.println("Say something: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
