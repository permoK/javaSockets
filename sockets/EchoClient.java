import java.net.Socket;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client started");
            // Socket soc = new Socket("54.237.50.146",3306);
            Socket soc = new Socket("localhost", 1212);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // Loop to continuously send and receive messages
            while (true) {
                System.out.println("Enter message to send to server");
                String str = userInput.readLine();
                out.println(str);

                String sstr = in.readLine();
                System.out.println("Message from server: " + sstr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

