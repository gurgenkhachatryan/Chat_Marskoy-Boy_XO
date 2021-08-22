import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server12 {
    public static void main(String[] args) throws Exception {
            ExecutorService executorService = Executors.newFixedThreadPool(2);


        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket2= serverSocket.accept();

        Socket socket1 = serverSocket.accept();


        Runnable task1 = (() -> {
            try {
                InputStream inputStream1 = socket1.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream1);
                String input1ic = (String) objectInputStream.readObject();
                System.out.println(input1ic);

                OutputStream outputStream = socket2.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                String output2in = input1ic;
                objectOutputStream.writeObject(output2in);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        });

        executorService.execute(task1);
        executorService.shutdown();
        Runnable task2 = (() -> {
            try {
                InputStream inputStream2 = socket2.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream2);
                String input2ic = (String) objectInputStream.readObject();
                System.out.println(input2ic);

                OutputStream outputStream = socket1.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                String output1in = input2ic;
                objectOutputStream.writeObject(output1in);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        });





executorService.execute(task2);
executorService.shutdown();


    }
}
