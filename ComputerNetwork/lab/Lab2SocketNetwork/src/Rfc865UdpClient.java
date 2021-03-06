/*
 * Name : Park, Jee Hyun
 * Group : BCE3
 * IP Address : 172.21.145.27
 */

import java.io.*;
import java.net.*;
import java.lang.*;

public class Rfc865UdpClient {
    public static void main(String args[]) {
        //
        // 1. Open UDP socket
        //

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
        // make a buffer
        byte[] Buffer1 = new byte[1024];

        try {
        	
        	System.out.print("put any message : ");

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String sentence = inFromUser.readLine();
            Buffer1 = sentence.getBytes();

            InetAddress IPAddress = InetAddress.getByName("localhost");
            // "localhost"
            // "hw1-b00"
            // CE3005 HWLAB B18 : 172.21.145.27

            //
            // 2. Send UDP request(sendPacket) to server
            //

            DatagramPacket sendPacket = new DatagramPacket(Buffer1, Buffer1.length, IPAddress, 1234);
            socket.send(sendPacket);

            //
            // 3. Receive UDP reply(recievePacket) from server
            //
            
            
            Buffer1 = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(Buffer1, Buffer1.length);
            // DatagramPacket(byte [] buff, int length) : receiving -> two parameter
            socket.receive(receivePacket);
            
            
            
            String receivedSentence = new String(receivePacket.getData());

            // print the result
            System.out.println("< FROM SERVER >");
            System.out.println(receivedSentence);
            
            socket.close();
      
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}