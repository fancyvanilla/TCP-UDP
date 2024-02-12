package UDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

    public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9876);
            System.out.println("UDP Server is running and waiting for datagrams...");
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received from client: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
