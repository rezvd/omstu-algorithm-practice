package omstu.task01_workers;

public class LinkedList<T> {
    private Node<T> start;
    private Node<T> current;

    public LinkedList() {
        start = null;
        current = null;
    }

    public void addElement(final T element) {
        Node<T> newNode = new Node<>(element);
        if (current != null) {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        } else {
            start = newNode;
        }
        current = newNode;
    }

    public Node<T> deleteElement() {
        if (current != null && current.getNext() != null) {
            Node<T> deletingNode = current.getNext();
            current.setNext(deletingNode.getNext());
            return deletingNode;
        }
        return null;
    }

    public T get() {
        if (current != null) {
            return current.getValue();
        }
        return null;
    }

    public void next() {
        if (current != null) {
            current = current.getNext();
        }
    }

    public void goToStart() {
        current = start;
    }

    public T getStart() {
        return start.getValue();
    }
}
