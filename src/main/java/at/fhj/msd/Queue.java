package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Queue<T> implements IQueue<T> {

    private List<T> elements = new ArrayList<T>();
    private int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(T obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }

    @Override
    public T poll() {
        T element = peek();

        if (elements.size() != 0) {
            elements.remove(0);
        }

        return element;
    }

    @Override
    public T remove() {
        T element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    @Override
    public T peek() {
        if (elements.size() > 0)
            return elements.get(0);
        else
            return null;
    }

    @Override
    public T element() {
        T element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    public List<T> getElements() {
        return elements;
    }
}