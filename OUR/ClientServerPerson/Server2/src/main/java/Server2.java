import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        Person2 person2=new Person2();
        Gson gson=new Gson();

        try {
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket= serverSocket.accept();

            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            Person2 stacvac=gson.fromJson((String) objectInputStream.readObject(),Person2.class);
   //     Person2 stacvox=(String)    objectInputStream.readObject(person2);
            System.out.println(stacvac);



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
