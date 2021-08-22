import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {

        try {
            Scanner scanner=new Scanner(System.in);
            String str= scanner.nextLine();
            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(str);

            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            String patstr=(String) objectInputStream.readObject();
            System.out.println(patstr);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
