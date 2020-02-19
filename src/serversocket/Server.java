/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 *
 * @author majd1
 */
public class Server {
        public static void main(String args[]) throws IOException
    { 
  
        // Establish the socket connection. 
        ServerSocket ss = new ServerSocket(3006); 
        System.out.println("Server is ready for connections: ");
        Socket s = ss.accept(); 
        
        System.out.println("There is a client");
  
        //  Processing the request. 
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        while (true) 
        { 
            // wait for input 
            String input = dis.readUTF(); 
  
            if(input.equals("bye")) 
                break; 
  
            System.out.println("Equation received:-" + input); 
            int result; 
  
            // Use StringTokenizer to break the equation into operand and 
            // operation 
            StringTokenizer st = new StringTokenizer(input); 
  
            int number1 = Integer.parseInt(st.nextToken()); 
            String operation = st.nextToken(); 
            int number2 = Integer.parseInt(st.nextToken()); 
  
            // perform the required operation. 
            if (operation.equals("+")) 
            { 
                result = number1 + number2; 
            } 
  
            else if (operation.equals("-")) 
            { 
                result = number1 - number2; 
            } 
            else if (operation.equals("*")) 
            { 
                result = number1 * number2; 
            } 
            else
            { 
                result = number1 / number2; 
            } 
            System.out.println("Client Entered :\nfirst number: "+number1);
            System.out.println("Second number: "+number2);
            System.out.println("Result: "+ result);
            System.out.println("Sending the result to the  client..."); 
  
            // send the result back to the client. 
            dos.writeUTF(Integer.toString(result)); 
        } 
    } 
}
