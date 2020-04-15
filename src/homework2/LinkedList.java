/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.operation.ListIsEmptyException;
import homework2.operation.Operation;

/**
 * @author EEB
 */
public class LinkedList {

    private Node first;
    private int count;

    public LinkedList() {
    }

    public int length() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node prev = null;
            Node curr = first;
            while (curr != null && curr.getData() <= data) {
                prev = curr;
                curr = curr.getNext();
            }

            if (curr == first) {
                newNode.setNext(curr);
                first = newNode;
            } else {
                newNode.setNext(curr);
                prev.setNext(newNode);
            }
        }
        count++;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        } else {
            Node curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return curr.getData();
        }
    }

    public int indexOf(int data) {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        Node curr = first;
        int index = 0;
        while (curr != null && curr.getData() < data) {
            curr = curr.getNext();
            index++;
        }
        if (curr == null || curr.getData() != data) {
            return -1;
        } else {
            return index;
        }
    }

    public boolean remove(int data) {
        if (isEmpty()) {
            throw new ListIsEmptyException();
        }
        Node prev = null;
        Node curr = first;
        while (curr != null && curr.getData() < data) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr == null || curr.getData() != data) {
            return false;
        } else {
            if (curr == first) {
                first = curr.getNext();
            } else {
                prev.setNext(curr.getNext());
            }
            curr.setNext(null);
            count--;
            return true;
        }
    }

    public void removeFirst() {
        if (first != null) {
            Node oldFirst = first;
            first = first.getNext();
            oldFirst.setNext(null);
            count--;
        }
    }

    public void perform(Operation operation) {
        Node curr = first;
        while (curr != null) {
            int newData = operation.operate(curr.getData());
            curr.setData(newData);
            curr = curr.getNext();
        }
    }

    public int[] toArray() {
        int[] array = new int[count];
        Node curr = first;
        int index = 0;
        while (curr != null) {
            array[index++] = curr.getData();
            curr = curr.getNext();
        }
        return array;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty LinkedList";
        }
        StringBuilder builder = new StringBuilder("[");
        Node curr = first;
        while (curr.getNext() != null) {
            builder.append(curr.toString()).append(", ");
            curr = curr.getNext();
        }
        builder.append(curr);
        builder.append("]");
        return builder.toString();
    }
}
