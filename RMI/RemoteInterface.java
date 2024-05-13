import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface defining the method to be invoked remotely
public interface RemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}

