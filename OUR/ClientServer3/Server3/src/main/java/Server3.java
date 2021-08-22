import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket= serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            String str=(String) objectInputStream.readObject();
            System.out.println(str);


            Scanner scanner=new Scanner(System.in);
            String patstr= scanner.nextLine();
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(patstr);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
