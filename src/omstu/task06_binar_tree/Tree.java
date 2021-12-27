package omstu.task06_binar_tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Node<T> rootNode;

    public Tree() {
        rootNode = null;
    }

    public Node<T> findNodeByValue(long value) {
        Node<T> currentNode = rootNode;
        while (currentNode.getValue() != value) {

            currentNode = value < currentNode.getValue() ? currentNode.getLeftChild() : currentNode.getRightChild();
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public void insertNode(long value, T data) {
        Node<T> newNode = new Node<T>(value, data);
        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            Node<T> currentNode = rootNode;
            Node<T> parentNode;
            while (true)
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                }
                else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public List<T> getValues() {
        List<T> list = new ArrayList<>();
        recursion(rootNode, list);
        return list;
    }

    void recursion(Node<T> node, List<T> list){
        if (node.getLeftChild() != null) recursion(node.getLeftChild(), list);
        if (node.getRightChild() != null) recursion(node.getRightChild(), list);
        list.add(node.getData());
    }

}
