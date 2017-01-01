import java.net.Socket;

/**
 * Created by selim on 1/1/2017.
 */
public class ClientWorker implements Runnable{
    private Socket socket;
    public ClientWorker(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        
    }
}
