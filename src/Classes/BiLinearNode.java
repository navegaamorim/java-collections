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
public class BiLinearNode<T extends Comparable<T> > implements Comparable<BiLinearNode<T>>{

    private BiLinearNode<T> previous;
    private T element;
    private BiLinearNode<T> next;

    public BiLinearNode(T element) {
        this.element = element;
    }

    public BiLinearNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(BiLinearNode<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BiLinearNode<T> getNext() {
        return next;
    }

    public void setNext(BiLinearNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "element = " + element;
    }


    @Override
    public int compareTo(BiLinearNode<T> o) {
        return this.element.compareTo(o.element);
    }

}
