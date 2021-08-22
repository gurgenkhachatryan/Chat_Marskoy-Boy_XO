import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost", 8080);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Scanner scanner = new Scanner(System.in);

        Runnable task1 = (() ->
        {

            try {
                while (true) {
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    String str = (String) objectInputStream.readObject();
                    if (str != null) {
                        System.out.println("CLIENT 2: \n" + str);
                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        });


        Runnable task2 = (() ->
        {
            try {
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    String out = scanner.nextLine()+"\nCLIENT 2: ";
                    objectOutputStream.writeObject(out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();
    }
}
