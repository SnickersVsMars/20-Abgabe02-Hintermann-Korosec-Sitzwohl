package at.fhj.msd.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class represents a queue containing any given object
 *
 * @author      Christian Sitzwohl
 * @version     %I%, %G%
 * @since       1.1
 */
public class Queue<T> implements IQueue<T> {

    /**
     * elements in the queue
     */
    private List<T> elements = new ArrayList<T>();
    /**
     * maximum amount of elements in the queue
     */
    private int maxSize;

    /**
     * Creates a new Queue object with a given maximum size
     *
     * @param maxSize maximum amount of elements in the queue
     */
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
}