import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// RMI server that exports the remote object
public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            RemoteImpl obj = new RemoteImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Default port for RMI registry
            registry.rebind("RemoteObject", obj); // Bind the remote object to the registry
            
            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

