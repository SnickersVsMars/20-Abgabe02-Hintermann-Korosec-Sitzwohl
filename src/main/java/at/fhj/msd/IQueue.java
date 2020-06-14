package at.fhj.msd;

public interface IQueue<T> {
  /**
   * Adds the element obj to the queue.
   * If the addition is successful, the method returns true else false.
   *
   * @param T that should be added to the queue
   * @return true if the addition is successful - else false
   */
  public abstract boolean offer(T obj);

  /**
   * Returns the head (first) element and also deletes it. That is, we cannot get it again.
   * If no element exists (when queue is empty), the method returns null.
   *
   * @return head element of the queue
   */
  public abstract T poll();

  /**
   * It also returns and deletes the head element like poll(), but with a small difference.
   * This method throws NoSuchElementException if the queue is empty.
   *
   * @return head element of the queue
   */
  public abstract T remove();

  /**
   * Returns the head element but it does not delete it. That is, we can get it again.
   * Returns null when the queue is empty.
   *
   * @return head element of the queue
   */
  public abstract T peek();

  /**
   * It works similar to peek() but with a small difference (returns but does not delete the element).
   * It throws NoSuchElementException when the queue is empty.
   *
   * @return head element of the queue
   */
  public abstract T element();
}
