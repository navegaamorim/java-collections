/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stacks;

import Classes.LinearNode;
import Exceptions.EmptyStackException;
import Interfaces.StackADT;

/**
 *
 * @author navega
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinearNode top;
    private int count;

    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public void push(T element) {
        LinearNode temp = new LinearNode(element);
        if (this.isEmpty()) {
            this.top = temp;
        } else {
            temp.setNext(this.top);
            this.top = temp;
        }
        this.count++;

    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("Empty Stack.");
        } else {
            LinearNode currentTop = null;
            currentTop = this.top;
            LinearNode temp = this.top.getNext();
            this.top = temp;
            count--;

            return (T) currentTop.getElement();
        }
    }

    @Override
    public T peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException("Empty Stack.");
        } else {
            return (T) this.top.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    public void printStack() {
        System.out.println("PRINT STACK");
        LinearNode temp = this.top;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
    
    

}
