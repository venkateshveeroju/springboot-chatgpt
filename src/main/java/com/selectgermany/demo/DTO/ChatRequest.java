package com.selectgermany.demo.DTO;



import java.util.ArrayList;
import java.util.List;

public class ChatRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperatures;
    public ChatRequest(String model, String prompt){
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message ("user", prompt));

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(double temperatures) {
        this.temperatures = temperatures;
    }
}
