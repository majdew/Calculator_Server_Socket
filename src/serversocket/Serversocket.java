/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author majd1
 */
public class Serversocket {

    /**
     * @param args the command line arguments
     */
    private Socket socket = null;
    private ServerSocket server = null;
    private Scanner scanin = null;
    private PrintStream printClient = null;

    public Serversocket(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("server is wating for clinets");

            socket = server.accept();
            System.out.println("There is a client!!! ");

            scanin = new Scanner(socket.getInputStream());
            double result = 0.0;
            int number1, number2;
            String operation;
            number1 = scanin.nextInt();
            number2 = scanin.nextInt();
            operation = scanin.next();
            System.out.println("Client entered : \nfirst value : " + number1 + "\nsecond value :" + number2);

            switch (operation) {
                case "mult": {
                    result = number1 * number2;
                }
                break;
                case "div": {
                    result = number1 / number2;
                }
                break;
                case "sub": {
                    result = number1 - number2;
                }
                break;
                case "sum": {
                    result = number1 + number2;
                }
                break;
            }
            System.out.println("send the result : " + result);
            printClient = new PrintStream(socket.getOutputStream());
            printClient.println(result);

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Serversocket serversocket = new Serversocket(3006);
    }

}
