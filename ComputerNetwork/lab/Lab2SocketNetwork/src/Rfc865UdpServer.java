import java.io.*;
import java.net.*;

public class Rfc865UdpServer {
    public static void main(String args[]) {

        //
        // 1. Open UDP socket at well-known port
        //

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(1234);
        } catch (SocketException e) {
        	e.printStackTrace();
        }
        
        // make a buffer
        byte[] Buffer = new byte[1024];

        while (true) {
            try {

                //
                // 2. Listen for UDP request(recivePacket) from client
                //
            	
            	Buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(Buffer, Buffer.length);
                // DatagramPacket(byte [] buff, int length) : receiving -> two parameter
                socket.receive(receivePacket);

                // print received data
                
                
                String receivedSentence = new String(receivePacket.getData());
                System.out.println("RECEIVED : " + receivedSentence);

                // extract IP address & port number
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                // modify the received sentence
                String sentence = "Are you sure that a floor can not be a ceiling?";
                Buffer = sentence.getBytes();

                //
                // 3. Send UDP reply(sendPacket) to client
                //

                DatagramPacket sendPacket = new DatagramPacket(Buffer, Buffer.length, IPAddress, port);
                // DatagramPacket(byte [] buff, int length, InetAddress address, int port) : sending -> four parameter
                socket.send(sendPacket);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
}