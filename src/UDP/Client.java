package UDP;

// UDPClient.java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String message = "Hello, server!";
            byte[] buffer = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 9876);
            datagramSocket.send(packet);
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
