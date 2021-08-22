import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket=serverSocket.accept();

            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
          String str=(String)  objectInputStream.readObject();
            System.out.println(str);

            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            Scanner scanner=new Scanner(System.in);
            objectOutputStream.writeObject(scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
