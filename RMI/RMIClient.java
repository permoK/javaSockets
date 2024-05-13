import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// RMI client that looks up the remote object and invokes its method
public class RMIClient {
    public static void main(String[] args) {
        try {
            // Obtain a reference to the remote object from the registry
            // Registry registry = LocateRegistry.getRegistry("54.237.50.146", 1212); // Default port for RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1313); // Default port for RMI registry
            RemoteInterface obj = (RemoteInterface) registry.lookup("RemoteObject");
            
            // Invoke the remote method
            String response = obj.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

