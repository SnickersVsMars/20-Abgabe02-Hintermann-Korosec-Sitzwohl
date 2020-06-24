package at.fhj.msd.queue;

/**
 * Interface containing the essential queue methods.
 *
 * @author      Michael Ulm
 * @author      Christian Sitzwohl
 * @version     %I%, %G%
 * @since       1.0
 */
public interface IQueue<T> {
  /**
   * Adds the element obj to the queue.
   * If the addition is successful, the method returns true else false.
   *
   * @param obj that should be added to the queue
   *
   * @return true if the addition is successful - else false
   */
  boolean offer(T obj);

  /**
   * Returns the head (first) element and also deletes it. That is, we cannot get it again.
   * If no element exists (when queue is empty), the method returns null.
   *
   * @return head element of the queue
   */
  T poll();

  /**
   * It also returns and deletes the head element like poll(), but with a small difference.
   * This method throws NoSuchElementException if the queue is empty.
   *
   * @return head element of the queue
   */
  T remove();

  /**
   * Returns the head element but it does not delete it. That is, we can get it again.
   * Returns null when the queue is empty.
   *
   * @return head element of the queue
   */
  T peek();

  /**
   * It works similar to peek() but with a small difference (returns but does not delete the element).
   * It throws NoSuchElementException when the queue is empty.
   *
   * @return head element of the queue
   */
  T element();
}
