import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        Gson gson=new Gson();
        try {

            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket= serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            Person1 person1=gson.fromJson((String) objectInputStream.readObject(),Person1.class);

            System.out.println(person1);



        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
