/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.NotSupportComparable;

/**
 *
 * @author navega
 */
public interface OrderedListADT<T> extends ListADT<T> {

    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     * @throws ed_05.NotSupportComparable
     */
    public void add(T element) throws NotSupportComparable;
}
