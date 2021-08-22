import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket socket=new ServerSocket(8080);
            Socket socket1=socket.accept();
            InputStream inputStream=socket1.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            String str=(String) objectInputStream.readObject();
            System.out.println(str);

            OutputStream outputStream=socket1.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject("valod");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
