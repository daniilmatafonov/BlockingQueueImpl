package com.queue;

import com.model.SimpleMessage;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImplBlockingQueue implements BlockingQueue<SimpleMessage> {
    final Lock lock = new ReentrantLock();
    int defaultSize = 5;

    final Condition produce = lock.newCondition();
    final Condition consume = lock.newCondition();

    final SimpleMessage[] messages = new SimpleMessage[defaultSize];
    int producerIndex, consumerIndex;
    int count;

    public boolean add(SimpleMessage simpleMessage) {
        lock.lock();
        try {
            while (count == messages.length){
                try {
                    produce.await();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            messages[producerIndex] = simpleMessage;
            System.out.println("put - " + simpleMessage.getText());
            producerIndex++;
            if (producerIndex == messages.length){
                producerIndex = 0;
            }
            ++count;
            consume.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }

    public SimpleMessage take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                consume.await();
            }
            SimpleMessage message = messages[consumerIndex];
            System.out.println("take - " + message.getText());
            consumerIndex++;
            if (consumerIndex == messages.length){
                consumerIndex = 0;
            }
            --count;
            produce.signal();
            return message;
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(SimpleMessage simpleMessage) {
        return false;
    }

    public SimpleMessage remove() {
        return null;
    }

    public SimpleMessage poll() {
        return null;
    }

    public SimpleMessage element() {
        return null;
    }

    public SimpleMessage peek() {
        return null;
    }

    public void put(SimpleMessage simpleMessage) throws InterruptedException {
        add(simpleMessage);
    }

    public boolean offer(SimpleMessage simpleMessage, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public SimpleMessage poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<SimpleMessage> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public int drainTo(Collection<? super SimpleMessage> c) {
        return 0;
    }

    public int drainTo(Collection<? super SimpleMessage> c, int maxElements) {
        return 0;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends SimpleMessage> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        lock.lock();
        boolean changed = false;
        try {
            for (Object e : c) {
                if (remove(e)) {
                    changed = true;
                }
            }
            return changed;
        } finally {
            lock.unlock();
        }
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public int size() {
        return messages.length;
    }

    public boolean isEmpty() {
        return false;
    }
}
