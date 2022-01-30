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
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
/*
 * www.codeurjava.com
 */
public class client {

   public static void main(String[] args) throws IOException {
        
        String serverAddress = new Scanner(System.in).nextLine();
        Socket socket = new Socket(serverAddress, 9090);
        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String sentence =" rafiaa jnaieh ";
        out.println(sentence);
        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();
        System.out.println("Server response: " + response);
    }
}
