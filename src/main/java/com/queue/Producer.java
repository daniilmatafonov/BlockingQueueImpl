package com.queue;

import com.model.SimpleMessage;

public class Producer extends Thread {
    private ImplBlockingQueue customBlockingQueue;

    public Producer(ImplBlockingQueue customBlockingQueue){
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                customBlockingQueue.put(new SimpleMessage("Message " + i));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
