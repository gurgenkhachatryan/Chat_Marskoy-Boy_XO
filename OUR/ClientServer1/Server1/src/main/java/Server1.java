import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket socket=new ServerSocket(8080);
            Socket stanal= socket.accept();
            InputStream inputStream=stanal.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            String str=(String) objectInputStream.readObject();
            System.out.println(str);

            OutputStream outputStream=stanal.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("hasela");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
