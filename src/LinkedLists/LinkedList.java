/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

import Classes.LinearNode;

/**
 *
 * @author navega
 */
public class LinkedList<T> {

    private LinearNode head, tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(LinearNode head, LinearNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public void add(T element) {
        LinearNode temp = new LinearNode(element);
        LinearNode current = this.head;
        if (isEmpty()) {
            this.head = temp;
            this.tail = temp;
        } else {
            this.tail.setNext(temp);
            this.tail = temp;
        }
    }

    public void remove(T element) {
        if (!isEmpty()) {
            boolean found = false;
            LinearNode current = this.head;
            LinearNode previous = null;

            while (current != null && found == false) {
                if (current.getElement().equals(element)) {
                    found = true;
                } else {
                    previous = current;
                    current = previous.getNext();
                }
            }

            if (found) {

                // primeiro mas nao unico
                if (current.equals(this.head)) {
                    this.head = current.getNext();
                } else if (current.getNext() == null) {//ultimo
                    previous.setNext(null);
                    this.tail = previous;
                } else if (current.getNext() != null && previous != null) {// meio da stack
                    previous.setNext(current.getNext());
                }

            }
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        String result = "";
        LinearNode current = this.head;
        while (current != null) {
            result = result + "\n" + current.toString();
            current = current.getNext();
        }
        return "LinkedNodeList" + "\n" + result;
    }

}
