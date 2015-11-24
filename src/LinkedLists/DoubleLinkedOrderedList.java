package LinkedLists;

import Classes.BiLinearNode;
import Exceptions.NotSupportComparable;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author navega
 */
public class DoubleLinkedOrderedList<T> extends ArrayLinkedList<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    @Override
    public void add(Object element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            Comparable temp = (Comparable) element;
            BiLinearNode newElement = new BiLinearNode((Comparable) element);
            BiLinearNode current = super.head;

            if (isEmpty()) {
                super.head = newElement;
                super.tail = newElement;

            } else if (temp.compareTo(super.tail.getElement()) >= 0) {//adicionar ao fim
                super.tail.setNext(newElement);
                newElement.setPrevious(super.tail);
                newElement.setNext(null);
                super.tail = newElement;

            } else if (temp.compareTo(head.getElement()) <= 0) {//adicionar ao inicio

                super.head.setPrevious(newElement);
                newElement.setNext(super.head);
                newElement.setPrevious(null);
                super.head = newElement;

            } else {// adicionar ao meio
                while (temp.compareTo(current.getElement()) > 0) {
                    current = current.getNext();
                }
                newElement.setNext(current);
                newElement.setPrevious(current.getPrevious());
                current.getPrevious().setNext(newElement);
                current.setPrevious(newElement);
            }
            ++count;
        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }

    @Override
    public String toString() {
        String result = "";
        BiLinearNode current = super.head;
        while (current != null) {
            result = result + "\n" + current.toString();
            current = current.getNext();
        }

        return "DoubleLinkedOrderedList" + "\n" + result;
    }

}
