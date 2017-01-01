import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8855);
            Socket socket = serverSocket.accept();
            DataInputStream inFromClient;
            DataOutputStream outToClient;

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
            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}