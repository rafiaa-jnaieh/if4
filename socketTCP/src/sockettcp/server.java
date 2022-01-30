/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockettcp;

/**
 *
 * @author Rafiaa
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/*
 * www.codeurjava.com
 */
public class server {
 
   public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090) ;
        System.out.println("The date server is running") ;
        Socket socket = listener.accept();
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();
        String newrep = response.toUpperCase();
        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(newrep);
                
            
        
    }
}