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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikolaj
 */
public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }

    private final int PORT = 1111;
    private final Counter counter = new Counter();

    public void run() throws IOException {
        ServerSocket SSocket = new ServerSocket(PORT);
        out.println("Server Started.");

        while (true) {
            Socket currentSocket = SSocket.accept();

            InputStreamReader isr = new InputStreamReader(currentSocket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            PrintStream ps = new PrintStream(currentSocket.getOutputStream());
            //Read first input to determinat type
            String type = br.readLine();

            if (type.equals("turnstil")) {
                new Thread(new Turnstil(br,ps, counter)).start();
            } else {
                new Thread(new Monitor(ps,counter)).start();
            }
        }
    }
}
