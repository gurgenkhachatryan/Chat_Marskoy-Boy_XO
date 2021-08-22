import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket1=new Socket("localHost",8080);
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Scanner scanner=new Scanner(System.in);
Runnable task1=(()-> {

    try {
        while (true) {
        InputStream inputStream = socket1.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        String erkusicarajin = (String) objectInputStream.readObject();
       if (erkusicarajin != null) {
            System.out.println("Client2: " + erkusicarajin);
        }   }
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }
});
executorService.execute(task1);
executorService.shutdown();

        while (true) {
            OutputStream outputStream = socket1.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            String mekicerkus = scanner.nextLine();
            objectOutputStream.writeObject(mekicerkus);
        }
    }


    }

