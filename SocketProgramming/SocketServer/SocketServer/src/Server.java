
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ridho akbar
 */
public class Server {
    public static void main(String[] args) throws IOException {
        
//        if (args.length != 1) {
//            System.err.println("Usage: java EchoServer <port number>");
//            System.exit(1);
//        }
        
//        int portNumber = Integer.parseInt(args[0]);
        int portNumber = 4447;
        
        try (
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(clientSocket.getLocalAddress()+":"+clientSocket.getLocalPort()+" >> "+ inputLine);
                out.println("Server: " + inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
