package TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            // Client receiving from server
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String messageServer1 = new String(buffer, 0, bytesRead);
            System.out.println("Received from the server: " + messageServer1);

            // Client writing to server
            Scanner scanner = new Scanner(System.in);
            OutputStream output = socket.getOutputStream();
            System.out.print("Enter the first input: ");
            int firstInput = scanner.nextInt();
            System.out.print("Enter the second input: ");
            int secondInput = scanner.nextInt();

            // Send the two integers as a formatted string
            String formattedInput = firstInput + " " + secondInput + "\n";
            output.write(formattedInput.getBytes());

            // Receiving from server
            byte[] buffer2 = new byte[1024];
            int bytesRead2 = input.read(buffer2);
            String messageServer2 = new String(buffer2, 0, bytesRead2);
            System.out.println("Received from the server: " + messageServer2);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

