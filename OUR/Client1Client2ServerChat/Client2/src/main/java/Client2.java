import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client2 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localHost", 8080);

//while (true){
            Runnable task1 = (() -> {
                try {

                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    while(true) {
                     if(objectInputStream.readObject()!=null) {
                            String mekicerku = (String) objectInputStream.readObject();
                            System.out.println(mekicerku);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            });
            executorService.execute(task1);
            executorService.shutdown();



while (true){

                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    String s= scanner.nextLine();
                    String str="client 2  " +s;
                    objectOutputStream.writeObject(str);

            }


    }
}
