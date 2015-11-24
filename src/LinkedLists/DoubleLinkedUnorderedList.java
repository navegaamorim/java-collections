package LinkedLists;

import Classes.BiLinearNode;
import Exceptions.NotFoundInCollectionException;
import Exceptions.NotSupportComparable;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Navega
 */
public class DoubleLinkedUnorderedList<T> extends ArrayLinkedList<T> {


    public DoubleLinkedUnorderedList() {
        super();
    }

    @Override
    public void addToFront(Object element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            BiLinearNode newElement = new BiLinearNode((Comparable) element);
            if (this.isEmpty()) {
                this.head = newElement;
                this.tail = newElement;
            } else {
                this.head.setPrevious(newElement);
                newElement.setNext(this.head);
                this.head = newElement;

            }
            ++count;
        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }

    @Override
    public void addToRear(Object element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            BiLinearNode newElement = new BiLinearNode((Comparable) element);
            if (this.isEmpty()) {
                super.head = newElement;
                super.tail = newElement;
            } else {
                super.tail.setNext(newElement);
                newElement.setPrevious(super.tail);
                super.tail = newElement;
            }
            ++count;
        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }

    @Override
    public void addAfter(Object element, Object target) throws NotSupportComparable, NotFoundInCollectionException {
        if (element instanceof Comparable) {
            if (this.contains((T) target)) {
                BiLinearNode newElement = new BiLinearNode((Comparable) element);
                BiLinearNode targetElement = new BiLinearNode((Comparable) target);
                BiLinearNode current = super.head;

                while (current.compareTo(targetElement) != 0) {
                    current = current.getNext();
                }
                BiLinearNode previous = current.getNext();
                newElement.setNext(current.getNext());
                newElement.setPrevious(current);
                current.setNext(newElement);
                previous.setPrevious(newElement);

                ++count;
            } else {
                throw new NotFoundInCollectionException("Not found in Collection.");
            }
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
        return "DoubleLinkedUnOrderedList" + "\n" + result;
    }

}
