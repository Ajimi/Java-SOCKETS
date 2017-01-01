import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by selim on 1/1/2017.
 */
public class ClientSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8855);
            DataOutputStream outToServer;
            DataInputStream inFromServer;
            String str;
            outToServer = new DataOutputStream(socket.getOutputStream());
            inFromServer = new DataInputStream(socket.getInputStream());
            while(true){
                Scanner sc = new Scanner(System.in);
                str = sc.nextLine();
                if(str.equals("quit")) {
                    break;
                }
                outToServer.writeUTF(str);
                outToServer.flush();
                str = String.valueOf(inFromServer.readUTF());
                System.out.println("From Server: " + str);
            }

            outToServer.close();
            inFromServer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
