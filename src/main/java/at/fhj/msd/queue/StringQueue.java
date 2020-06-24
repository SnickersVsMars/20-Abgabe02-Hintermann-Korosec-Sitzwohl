package at.fhj.msd.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class represents a queue containing only string objects
 *
 * @author      Michael Ulm
 * @author      Marian Korosec
 * @version     %I%, %G%
 * @since       1.0
 */
public class StringQueue implements IQueue<String> {

  /**
   * elements in the queue
   */
  private List<String> elements = new ArrayList<String>();
  // Bug 1: max size assigned here and then again to itself
  // in the constructor, constructor parameter not used
  /**
   * maximum amount of elements in the queue
   */
  private int maxSize;

  /**
   * Creates a new Queue object with a given maximum size
   *
   * @param maxSize maximum amount of elements in the queue
   */
  public StringQueue(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  // Bug 2: Poll method calls remove if the List is empty
  // (= has 0 elements) -> wrong if condition
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) {
      elements.remove(0);
    }

    return element;
  }

  // Bug 3: Value of element is first assigned to the return value of
  // poll() and then overwritten by an empty string
  @Override
  public String remove() {
    String element = poll();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }
}