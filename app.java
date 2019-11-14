public class DoublyLinkedList<T> implements Iterable<T> {
  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  // Internal node class to represent data
  private static class Node<T> {
    private T data;
    private Node<T> prev, next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
//Hello
    @Override
    public String toString() {
      return data.toString();
    }
  }
 }