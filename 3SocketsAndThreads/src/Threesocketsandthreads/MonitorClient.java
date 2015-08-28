/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threesocketsandthreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.System.out;
import java.net.Socket;

/**
 *
 * @author Nikolaj
 */
public class MonitorClient {
    public static void main(String[] args) throws IOException {
        MonitorClient client = new MonitorClient();
        client.run();
    }
    
    private final int PORT = 1111;
    
    public void run() throws IOException {
        Socket socket = new Socket("localhost",PORT);
        out.printf("Connected to Server at #s \n",socket.getInetAddress());
                    
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);     
        
        

        PrintStream ps = new PrintStream(socket.getOutputStream());
        
        ps.println("Monitor");
        
        String input = null;
        while (!(input = br.readLine()).equals("Exit")) {
            System.out.println(input);
        }
        ps.println("close");
        socket.close();
        
    }
}
