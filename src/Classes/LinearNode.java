/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author navega
 */
public class LinearNode<T> {

    private T element;
    private LinearNode next;

    public LinearNode() {
    }

    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinearNode getNext() {
        return next;
    }

    public void setNext(LinearNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "element = " + element;
    }

}
