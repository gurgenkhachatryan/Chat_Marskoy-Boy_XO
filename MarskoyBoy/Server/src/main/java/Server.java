import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(8080);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Socket socket1= serverSocket.accept();
        Socket socket2= serverSocket.accept();
        Runnable task1=()-> {


            try {while (true) {
                InputStream inputStream = socket1.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                String str1 = (String) objectInputStream.readObject();
                OutputStream outputStream = socket2.getOutputStream();
                ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
                objectOutput.writeObject(str1);
            }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        };
        Runnable task2=()-> {
            try {while (true) {
                InputStream inputStream = socket2.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                String str2 = (String) objectInputStream.readObject();
                OutputStream outputStream = socket1.getOutputStream();
                ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
                objectOutput.writeObject(str2);
            }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();

    }
}
