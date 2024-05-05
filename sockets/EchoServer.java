import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
	public static void main(String[] args) {
		try
		{
			System.out.println("Server started");
			ServerSocket ss = new ServerSocket(1212);

			Socket soc = ss.accept();
			
			System.out.println("Connection established");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
