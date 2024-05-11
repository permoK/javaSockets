import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class EchoServer{
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients to connect...");
            ServerSocket ss = new ServerSocket(1212);
            
            // Keep the server running indefinitely
            while (true) {
                Socket soc = ss.accept();
                // System.out.println("Connection established with " + soc.getInetAddress());

                // Handle the client request in a separate thread to allow concurrent connections
                new Thread(new ClientHandler(soc)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // receive a message from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine();
            // System.out.println("Message from client: " + str);
            System.out.println("received: "+str);

            // Enter the response to send to client
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            // System.out.println("Enter response: ");
			System.out.print("Send: ");
            String response = userInput.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(response);

            // Close the resources
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

