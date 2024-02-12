package TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("TCP Server is running and waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // Writing to client
                OutputStream output = socket.getOutputStream();
                String response = "Hey Client! Lets multiply 2 numbers";
                output.write(response.getBytes());

                // Reading input from client
                InputStream input = socket.getInputStream();
                Scanner scanner = new Scanner(input);

                // Read first and second numbers from the formatted string
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();

                // Calculate the product
                int product = num1 * num2;

                // Writing the result to the client
                output.write(String.valueOf(product).getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

