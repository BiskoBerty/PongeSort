/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/**
 *
 * @author galimberti.riccardoe
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(6666);
        } catch (IOException ex) {
            
        }
        try {
            while(true){
                System.out.println("server in attesa di richiesta...");
                
                Socket client = ss.accept();
                System.out.println("un client connesso!!!!!!!!!!");
                
                OutputStream OS = client.getOutputStream();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(OS));
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                out.write("ecco il carattere: " + in.readLine());
                
                out.close();
                in.close();
                client.close();
                System.out.println("chiusura connessione effettuata.");
            }
        }catch (IOException ex) {
                
        }
    }
}
