/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortedArrays;


import Exceptions.NotFoundInCollectionException;
import Exceptions.NotSupportComparable;
import java.util.Iterator;

/**
 *
 * @author Navega
 */
public class ArrayUnorderedList<T> extends ArrayList<T> {

    @Override
    public void addAfter(Object element, Object target) throws NotSupportComparable, NotFoundInCollectionException {
        Iterator iterator = super.iterator();
        int pos = 0;
        while (iterator.hasNext()) {
            ++pos;
            if (iterator.next().equals(target)) {
                super.shiftArray(pos);
                super.list[pos] = (T) element;
                ++super.rear;
            }
        }
    }

    @Override
    public void addToRear(Object element) throws NotSupportComparable {
        super.shiftArray(rear);
        super.list[rear] = (T) element;
        ++super.rear;
    }

    @Override
    public void addToFront(Object element) throws NotSupportComparable {
        super.shiftArray(0);
        super.list[0] = (T) element;
        ++super.rear;
    }

}
