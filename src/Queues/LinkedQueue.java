/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

import Classes.LinearNode;
import Exceptions.EmptyQueueException;
import Interfaces.QueueADT;

/**
 *
 * @author navega
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int count;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode temp = new LinearNode(element);
        if (this.isEmpty()) {
            this.front = temp;
            this.rear = temp;
        } else {
            this.rear.setNext(temp);
            this.rear=temp;
        }
        ++count;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (!isEmpty()) {
            T temp = this.front.getElement();
            this.front = this.front.getNext();
            count--;
            return temp;
        } else {
            throw new EmptyQueueException("Empty Queue");
        }
    }

    @Override
    public T first() {
        return this.front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String text = "";
        LinearNode current = this.front;
        while (current != null) {
            text = text + "\n" + current.toString();
            current = current.getNext();
        }
        return "\nLinkedQueue" + "\n" + text;
    }

}
