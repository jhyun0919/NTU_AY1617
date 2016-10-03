import java.io.*;
import java.net.*;

public class UDPClient {
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
        byte[] Buffer = new byte[1024];

        try {

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            String sentence = inFromUser.readLine();
            Buffer = sentence.getBytes();

            InetAddress IPAddress = InetAddress.getByName("localhost");
            // "localhost"

            //
            // 2. Send UDP request(sendPacket) to server
            //

            DatagramPacket sendPacket = new DatagramPacket(Buffer, Buffer.length, IPAddress, 1234);
            socket.send(sendPacket);

            //
            // 3. Recieve UDP reply(recievePacket) from server
            //

            DatagramPacket receivePacket = new DatagramPacket(Buffer, Buffer.length);
            socket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData());
            System.out.println("FROM SERVER : " + modifiedSentence);
      
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}