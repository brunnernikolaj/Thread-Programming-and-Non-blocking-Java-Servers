/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threesocketsandthreads;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikolaj
 */
public class Monitor implements Runnable {

    PrintStream writer;
    Counter counter;

    public Monitor(PrintStream writer, Counter counter) {
        this.writer = writer;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                writer.println(counter.getCount());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
