import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serverh {
    private  static Socket accept1;
    private static Socket accept2;
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(8080);
         accept1 = serverSocket.accept();
         accept2 = serverSocket.accept();
        Runnable task1 = (() -> {
    try {
        while (true) {
        InputStream inputStream = accept1.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        String mekicserver = (String) objectInputStream.readObject();
        if(mekicserver!=null) {
      //      System.out.println(mekicserver);
            sendAll(mekicserver);
        }
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

        });


       Runnable task2=(()->{
            try {
                while (true) {
                    InputStream inputStream = accept2.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    String erkusicmek = (String) objectInputStream.readObject();
                    if(erkusicmek!=null) {
                   //     System.out.println(erkusicmek);
                        sendAll(erkusicmek);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(task1);
        //  executorService.shutdown();
        executorService.execute(task2);
        executorService.shutdown();

    }

    private static void sendAll(String str) {
     //   OutputStream outputStream= null;
        try {
        OutputStream    outputStream = accept2.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(str);
        } catch (IOException e) {
            e.printStackTrace();
        }


     //   outputStream1= null;
        try {
            OutputStream      outputStream1 = accept1.getOutputStream();
            ObjectOutputStream objectOutputStream1=new ObjectOutputStream(outputStream1);
            objectOutputStream1.writeObject(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
