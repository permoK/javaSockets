import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1212);
            byte[] receiveData = new byte[1024];
            
            System.out.println("Server started...");
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String receivedStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + receivedStr);
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter response: ");
                String response = userInput.readLine();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

