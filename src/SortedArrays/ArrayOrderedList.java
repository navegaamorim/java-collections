/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortedArrays;


import Exceptions.NotSupportComparable;
import java.util.Iterator;

/**
 *
 * @author navega
 */
public class ArrayOrderedList<T> extends ArrayList<T> {


    public ArrayOrderedList() {
        super();
    }

    @Override
    public void add(T element) throws NotSupportComparable {
        if (element instanceof Comparable) {
            if (rear + 1 == lenght) {//+1 para evitar encher totalmente o array e crashar ao fazer shift
                this.expandCapacity();
            }
            int i = 0, index = -1;
            boolean found = false;

            if (this.isEmpty()) {
                // first element
                list[0] = element;
                ++rear;

            } else {
                //finding element and position
                Comparable temp = (Comparable) list[0];

                while (found != true && temp != null) {
                    temp = (Comparable) list[i];
                    if (temp != null && temp.compareTo(element) == 1) {
                        index = i;
                        found = true;
                    }
                    ++i;
                }

                if (found) {
                    //shift elements in array
                    this.shiftArray(index);
                    list[index] = element;
                    ++rear;
                } else {
                    list[rear] = element;
                    ++rear;
                }
            }
        } else {
            throw new NotSupportComparable("Not support comparable.");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.rear; ++i) {
            result = result + "\n" + this.list[i].toString();
        }
        return "ArrayOrderedList " + "\n" + result;
    }
}
