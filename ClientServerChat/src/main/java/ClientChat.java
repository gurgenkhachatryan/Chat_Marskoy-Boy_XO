import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    public static void main(String[] args) {
      //  while (true)
       // {
        try {
            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            Scanner scanner=new Scanner(System.in);
            String str= scanner.nextLine();
            objectOutputStream.writeObject(str);

            InputStream  inputStream=socket.getInputStream();
           ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        String sr=(String)   objectInputStream.readObject();
            System.out.println(sr);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
