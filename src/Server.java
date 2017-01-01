import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8855);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientWorker worker = new ClientWorker(socket);
                Thread t = new Thread(worker);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}