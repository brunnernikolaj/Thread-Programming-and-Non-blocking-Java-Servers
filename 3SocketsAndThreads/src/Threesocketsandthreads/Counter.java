/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threesocketsandthreads;

/**
 *
 * @author Nikolaj
 */
public class Counter {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }    
}
