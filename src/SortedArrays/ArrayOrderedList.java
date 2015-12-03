/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortedArrays;

import Exceptions.NotSupportComparable;
import Interfaces.OrderedListADT;

/**
 *
 * @author navega
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
        super();
    }

    protected ArrayOrderedList(int lenght) {
        super(lenght);
    }

    @Override
    public void add(T element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            if (this.size() == this.lenght) {
                this.expandCapacity();
            }

            Comparable<T> temp = (Comparable<T>) element;
            int scan = 0;
            while (scan < this.rear && temp.compareTo(list[scan]) > 0) {
                ++scan;
            }

            //shift
            for (int i = rear; i > scan; --i) {
                list[i] = list[i - 1];
            }

            list[scan] = element;
            ++rear;

        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }
}
