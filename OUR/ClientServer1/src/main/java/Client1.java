import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        Gson gson=new Gson();
        Faker faker=new Faker();
        try {
            Socket socket=new Socket("localhost",8080);
            String str="Hello";

            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(str);

            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
           String stacvoxstr=(String) objectInputStream.readObject();
            System.out.println(stacvoxstr);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
