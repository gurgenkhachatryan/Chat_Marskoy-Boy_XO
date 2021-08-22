import java.io.*;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {

        try {
            String str="Hello";
            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(str);

            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            String str1=(String)objectInputStream.readObject();
            System.out.println(str1);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
