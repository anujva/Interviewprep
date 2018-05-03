

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
  LinkedList<Item> linkedList;
  private Node<Item> head;
  private Node<Item> tail;
  private int length;

  public Deque() {
    linkedList = new LinkedList<Item>();
  }

  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();
    deque.addFirst(1);
    deque.addLast(2);
    deque.addLast(3);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);
    System.out.println("");
    System.out.println("");
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println(deque.removeFirst());
    System.out.println("Size: " + deque.size());
    System.out.println();
    System.out.println(deque.size());
    deque.addFirst(1);
    deque.addLast(2);
    deque.addLast(3);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);
    System.out.println("Printing out values using the iterator");
    Iterator<Integer> itemIterator = deque.iterator();
    while (itemIterator.hasNext()) {
      System.out.println(itemIterator.next());
    }
  }

  public boolean isEmpty() {
    if (length == 0) {
      return true;
    }
    return false;
  }

  public int size() {
    return length;
  }

  public void addFirst(Item item) {
    if (item == null) {
      throw new NullPointerException("Element you are trying to enter cannot be null");
    }

    if (head == null) {
      //set length to zero
      length = 0; //this could be an assert if required
      head = new Node<Item>(item);
      head.prevNode = null;
      head.nextNode = null;
      tail = head;
      length++;
      return;
    }
    /**
     *  |__|
     */
    Node<Item> node = new Node<Item>(item);
    head.prevNode = node;
    node.nextNode = head;
    head = node;
    length++;
  }

  public void addLast(Item item) {
    if (tail == null) {
      length = 0;
      tail = new Node<Item>(item);
      head = tail;
      length++;
      return;
    }

    Node<Item> node = new Node<Item>(item);
    tail.nextNode = node;
    node.prevNode = tail;
    tail = node;
    length++;
  }

  private void printItemsFromHead() {
    Node<Item> temp = head;
    while (temp != null) {
      System.out.println(temp.getItem());
      temp = temp.getNextNode();
    }
  }

  private void printItemsFromTail() {
    Node<Item> temp = tail;
    while (temp != null) {
      System.out.println(temp.getItem());
      temp = temp.getPrevNode();
    }
  }

  public Item removeFirst() {
    if (head == null) {
      assert length == 0;
      throw new NoSuchElementException("Deque is empty!");
    }
    Node<Item> temp = head;
    head = head.getNextNode();
    if (head != null) {
      head.prevNode = null;
    }
    temp.nextNode = null;
    length--;
    if (length == 0) {
      head = tail = null;
    }
    return temp.getItem();
  }

  public Item removeLast() {
    if (tail == null) {
      assert length == 0;
      return null;
    }

    Node<Item> temp = tail;
    tail = tail.getPrevNode();
    temp.prevNode = null;
    if (tail != null) {
      tail.nextNode = null;
    }
    length--;
    if (length == 0) {
      head = tail = null;
    }
    return temp.getItem();
  }

  public boolean hasNext() {
    return true;
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkedListIterator<Item>(this);
  }

  private static class LinkedListIterator<Item> implements Iterator<Item> {
    Node<Item> current;

    public LinkedListIterator(Deque linkedList) {
      current = linkedList.head;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (current == null) {
        throw new NoSuchElementException("There are no more elements to return");
      }
      Item item = current.getItem();
      current = current.getNextNode();
      return item;
    }
  }

  private static class Node<Item> {
    Item item;
    Node nextNode;
    Node prevNode;

    public Node(Item item) {
      this.item = item;
      nextNode = null;
      prevNode = null;
    }

    public Item getItem() {
      return item;
    }

    public void setItem(Item item) {
      this.item = item;
    }

    public Node getNextNode() {
      return nextNode;
    }

    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }

    public Node getPrevNode() {
      return prevNode;
    }

    public void setPrevNode(Node prevNode) {
      this.prevNode = prevNode;
    }
  }
}
