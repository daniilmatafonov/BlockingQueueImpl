package com.queue;

public class Consumer extends Thread {
    private ImplBlockingQueue customBlockingQueue;

    public Consumer(ImplBlockingQueue customBlockingQueue){
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                customBlockingQueue.take();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
