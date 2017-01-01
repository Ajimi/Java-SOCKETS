import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by selim on 1/1/2017.
 */
public class ClientWorker implements Runnable {
    private Socket socket;
    DataInputStream inFromClient;
    DataOutputStream outToClient;
    public ClientWorker(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {

        try{
            inFromClient = new DataInputStream(socket.getInputStream());

            outToClient = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = String.valueOf(inFromClient.readUTF());

                System.out.println("The client :" + str);
                Scanner sc = new Scanner(System.in);
                str = sc.nextLine();
                if (str.equals("quit")) {
                    break;
                }
                outToClient.writeUTF(str);
                outToClient.flush();

            }
            inFromClient.close();
            outToClient.close();

            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
