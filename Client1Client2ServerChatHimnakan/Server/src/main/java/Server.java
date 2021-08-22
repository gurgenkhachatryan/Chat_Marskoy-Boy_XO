import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
   //  private  static  String str1;
    // private  static  String str2;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket1 = serverSocket.accept();
        Scanner scanner = new Scanner(System.in);
        Socket socket2 = serverSocket.accept();
        Runnable task1 = () -> {

            try {
                while (true) {
                    InputStream inputStream1 = socket1.getInputStream();
                    ObjectInputStream objectInputStream1 = new ObjectInputStream(inputStream1);
                    String str1 = (String) objectInputStream1.readObject();

                    if (str1 != null ) {
                        OutputStream outputStream1 = socket2.getOutputStream();
                        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(outputStream1);
                        objectOutputStream1.writeObject(str1);
                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        };
        Runnable task2 = () -> {
            try {
                while (true) {
                    InputStream inputStream2 = socket2.getInputStream();
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStream2);
                   String str2 = (String) objectInputStream2.readObject();
              
                   if(str2!=null ){
                    OutputStream outputStream2 = socket1.getOutputStream();
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream2);
                    objectOutputStream2.writeObject(str2);
                }}
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();

    }
}


//                String serverOut1= scanner.nextLine();
//                String serverOut2= scanner.nextLine();
//                objectOutputStream1.writeObject(serverOut1);
//                objectOutputStream2.writeObject(serverOut2);
//                    System.out.println(str1);
//                    System.out.println(str2);



