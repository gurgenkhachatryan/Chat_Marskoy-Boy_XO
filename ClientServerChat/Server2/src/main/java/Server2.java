import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) throws IOException{

            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

        while (true) {
            try {

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                String clientic_Stacvac = (String) objectInputStream.readObject();
                System.out.println(clientic_Stacvac);
                if (clientic_Stacvac.equals("de helanq")) {
                    break;
                }

                Scanner scanner = new Scanner(System.in);
                String uxarkvox= scanner.nextLine();

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(uxarkvox);
                if(uxarkvox.equals("de helanq"))
                {
                    break;
                }


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
