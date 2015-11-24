/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searchs;


import Classes.BiLinearNode;
import Interfaces.OrderedListADT;
import java.util.Iterator;

/**
 *
 * @author Navega
 */
public class SearchingLinked<T extends Comparable<? super T>> {

    private OrderedListADT list;

    public SearchingLinked(OrderedListADT list) {
        this.list = list;
    }

    public void linearSearch(T element) {
        int pos = 0;
        boolean found = false;
        BiLinearNode tempNode = new BiLinearNode(element);
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            if (tempNode.compareTo((BiLinearNode) iterator.next()) == 0) {
                System.out.println("Found on position: " + (pos + 1));
                found = true;
            }
            ++pos;
        }

        if (!found) {
            System.out.println("Not found");
        }
    }

}
