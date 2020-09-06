package com.queue;

import com.model.SimpleMessage;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ImplBlockingQueue implements BlockingQueue<SimpleMessage> {
    public boolean add(SimpleMessage simpleMessage) {
        return false;
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

    }

    public boolean offer(SimpleMessage simpleMessage, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public SimpleMessage take() throws InterruptedException {
        return null;
    }

    public SimpleMessage poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    public int remainingCapacity() {
        return 0;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends SimpleMessage> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
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
}
