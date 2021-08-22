import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost", 8080);
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            try {
                while (true) {
                    InputStream inputStream = socket.getInputStream();

                    if (inputStream != null ) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        String str = (String) objectInputStream.readObject();
                        System.out.println("CLIENT 1: " + str);
                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        };


        Runnable task2 = () ->
        {
            try {
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    String out = scanner.nextLine()+"\nCLIENT 1: ";
                    objectOutputStream.writeObject(out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        };
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();

    }
}
