/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

import Interfaces.QueueADT;

/**
 *
 * @author navega
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private int lenght = 3;
    private int front;
    private int rear;
    private int count;
    private T[] queue;

    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.queue = (T[]) new Object[lenght];
    }

    private CircularArrayQueue(int lenght) {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.lenght = lenght;
        this.queue = (T[]) new Object[lenght];
    }

    @Override
    public void enqueue(T element) {
        if (this.count == this.lenght) {
            this.expand();
        }

        this.queue[rear] = element;
        rear = (rear + 1) % lenght;
        ++count;
    }

    @Override
    public T dequeue() {
        T temp = (T) this.queue[front];
        this.front = (front + 1) % lenght;
        --count;
        return temp;
    }

    @Override
    public T first() {
        return (T) this.queue[front];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String texto = "";
        int i;
        for (i = this.front; i < this.rear; ++i) {
            texto = texto + "\n" + queue[i].toString();
        }
        return "CircularArrayQueue " + "\n" + texto;
    }

    public void expand() {
        CircularArrayQueue tempQueue = new CircularArrayQueue(count * 2);
        while (!isEmpty()) {
            tempQueue.enqueue(this.dequeue());
        }
        this.front = tempQueue.front;
        this.rear = tempQueue.rear;
        this.count = tempQueue.count;
        this.lenght = tempQueue.lenght;
        this.queue = (T[]) tempQueue.queue;
    }

    //not yet implemented 
    public void classicExpand() {
        T[] tempQueue = (T[]) new Object[lenght * 2];
        int i;
        int index = 0;

        for (i = this.front;
                i
                < this.rear;
                ++i) {
            tempQueue[index] = this.queue[i];
            ++index;
        }

        this.queue = tempQueue;

    }
}
