/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searchs;

/**
 *
 * @author navega
 */
public class SearchingArray<T extends Comparable<? super T>> {

    private T[] list;
    private int size;

    public SearchingArray(T[] list, int size) {
        this.list = list;
        this.size = size;
    }

    public int linearSearch(T element) {
        for (int index = 0; index < this.list.length; ++index) {
            if (element.equals(this.list[index])) {
                return index;
            }
        }
        return -1;
    }

    /**
     * the list must be ordered
     * @param element
     * @return 
     */
    public int binarySearch(T element) {
        int first, last, middle, pos = -1;

        first = 0;
        last = size - 1;
        middle = size / 2;

        while (list[first].compareTo(list[last]) <= 0) {
            if (list[middle].compareTo(element) < 0) {
                first = middle + 1;
            } else if (list[middle].compareTo(element) == 0) {
                System.out.println(element.toString() + " found at location " + (middle + 1) + ".");
                pos = middle + 1;
                break;
            } else {
                last = middle - 1;
            }

            middle = (first + last) / 2;
        }
        if (first > last) {
            System.out.println(element + " is not present in the list.\n");
        }
        return pos;
    }
}
