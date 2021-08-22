import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client2h {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Socket socket=new Socket("localHost",8080);
        Runnable task1=()-> {

                //InputStream inputStream = null;
                try {
                    while (true) {
                        InputStream inputStream = socket.getInputStream();
                        //if(inputStream!=null){
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                        String mekicerkus = (String) objectInputStream.readObject();
                       if (mekicerkus != null) {
                           System.out.println("Client1: " + mekicerkus);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();

            }
        };
        executorService.execute(task1);
        executorService.shutdown();

                    while (true) {
                        OutputStream outputStream = socket.getOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        String erkusicmek = scanner.nextLine();
                        objectOutputStream.writeObject(erkusicmek);
                    }
                }

    }

