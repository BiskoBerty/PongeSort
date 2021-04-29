/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * @author galimberti.riccardoe
 */
public class Client {
    public static void main(String[] args) throws IOException {
        char[] list = new char[10];
        char[] l = {'a'+'b'+'c'+'d'+'e'+'f'+'g'+'h'+'i'+'j'+'k'+'l'+'m'+'n'+'o'+'p'+'q'+'r'+'s'+'t'+'u'+'v'+'w'+'y'+'z'};
        
        for (int i = 0; i < 10; i++) {
            list[i] = l[(int)Math.random()*l.length];
        }
        
        try{
            Socket server = new Socket("127.0.0.1", 6666);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            
//            while (true) {
                out.println(list[1]);
                String risposta = in.readLine();
                System.out.println(risposta);
//            }

            in.close();
            server.close();

            } catch (IOException ex) {
                System.out.println("IOException");
        }

    }
}
