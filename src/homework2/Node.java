/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 * @author EEB
 */
public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        setData(data);
    }

    void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
