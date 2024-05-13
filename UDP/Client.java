import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			while(true){
				DatagramSocket socket = new DatagramSocket();
				InetAddress serverAddress = InetAddress.getByName("localhost");
				byte[] sendData = new byte[1024];
				byte[] receiveData = new byte[1024];

				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

				System.out.print("Send: ");
				String str = userInput.readLine();
				sendData = str.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1212);
				socket.send(sendPacket);

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				String receivedStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Received: " + receivedStr);

				socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

