import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote interface
public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {
    public RemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from the remote object!";
    }
}

