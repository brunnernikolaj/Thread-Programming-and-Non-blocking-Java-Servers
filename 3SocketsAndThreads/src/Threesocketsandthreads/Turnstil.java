/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threesocketsandthreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikolaj
 */
public class Turnstil implements Runnable {

    BufferedReader reader;
    PrintStream writer;
    Counter counter;

    public Turnstil(BufferedReader socket,PrintStream writer, Counter counter) {
        this.reader = socket;
        this.writer = writer;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            String type;
            while (!(type = reader.readLine()).equals("close")) {
                counter.increment();
                writer.println(counter.getCount());
                System.out.println(counter.getCount());
            }
        } catch (IOException ex) {
            Logger.getLogger(Turnstil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
