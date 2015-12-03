/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortedArrays;

import Exceptions.NotSupportComparable;
import Interfaces.ListADT;
import java.util.Iterator;

/**
 *
 * @author Navega
 */
public class ArrayList<T> implements ListADT<T> {

    protected int lenght;
    protected T[] list;
    protected int rear;

    public ArrayList() {
        this.rear = 0;
        this.lenght = 3;
        this.list = (T[]) new Object[lenght];
    }

    protected ArrayList(int lenght) {
        this.rear = 0;
        this.lenght = lenght;
        this.list = (T[]) new Object[lenght];
    }

    @Override
    public T removeFirst() {
        T temp = this.first();
        this.shiftArrayBackWards(0);
        --rear;
        return temp;
    }

    @Override
    public T removeLast() {
        T temp = this.list[rear];
        this.list[rear] = null;
        --rear;
        return temp;
    }

    @Override
    public T remove(T element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            Comparable temp = (Comparable) list[0];
            T target = null;
            int index = 0;
            boolean found = false;

            while (found != true && temp != null) {
                temp = (Comparable) list[index];
                if (temp.compareTo(element) == 0) {
                    target = this.list[index];
                    this.shiftArrayBackWards(index);
                    --rear;
                    found = true;
                }
                ++index;
            }
            return target;
        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }

    @Override
    public T first() {
        return this.list[0];
    }

    @Override
    public T last() {
        return this.list[rear];
    }

    @Override
    public boolean contains(T target) throws NotSupportComparable {
        if (target instanceof Comparable) {
            int i = 0;
            for (i = 0; i < rear; ++i) {
                Comparable temp = (Comparable) list[i];
                if (temp.compareTo(target) == 0) {
                    return true;
                }
            }
        } else {
            throw new NotSupportComparable("Not support comparable");
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.rear == 0;
    }

    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Expands the lenght of array, by doubling the size of actual array
     *
     * @throws NotSupportComparable
     */
    public void expandCapacity() throws NotSupportComparable {
        ArrayUnorderedList<T> listTemp = new ArrayUnorderedList(this.lenght * 2);
        while (!this.isEmpty()) {
            T element = this.removeFirst();
            if (element != null) {
                listTemp.addToRear(element);
            }
        }
        System.out.println("Expanded Capacity from " + this.lenght + " to " + listTemp.lenght);

        this.rear = listTemp.rear;
        this.lenght = listTemp.lenght;
        this.list = listTemp.list;
    }

    /**
     * Does a shift to array, in reverse order, used in add method
     *
     * @param position - position where the shift ends, and the new element will
     * be inserted
     */
    public void shiftArray(int position) throws NotSupportComparable {
        int i;
        if (this.size() == this.lenght) {
            this.expandCapacity();
        }
        for (i = rear; i > position; --i) {
            list[i] = list[i - 1];
        }
    }

    /**
     * Does a shift to array, in normal order, used in remove method, and in
     * remove first method
     *
     * @param position - position when the shift ends
     */
    public void shiftArrayBackWards(int position) {
        int i;
        for (i = position; i < rear - 1; ++i) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.rear; ++i) {
            result = result + "\n" + this.list[i].toString();
        }
        return "ArrayList " + "\n" + result;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }

    public class BasicIterator<T> implements Iterator {

        private int count;

        @Override
        public boolean hasNext() {
            return count < size();
        }

        @Override
        public Object next() {
            Object temp = list[count];
            ++count;
            return temp;
        }
    }

}
