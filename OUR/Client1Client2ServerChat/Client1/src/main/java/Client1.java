import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client1 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Socket socket = new Socket("localHost", 8080);
        Scanner scanner = new Scanner(System.in);
     //   while (true) {
        Runnable task1=(()->{
            try {
                InputStream inputStream=socket.getInputStream();
                ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
               while(true) {
                   if (objectInputStream.readObject() != null) {
                       String s = (String) objectInputStream.readObject();
                       System.out.println(s);
                   }
               }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
executorService.execute(task1);
executorService.shutdown();
while (true) {

    OutputStream outputStream = socket.getOutputStream();
    String str = scanner.nextLine();
    String myStr = "client1 " + str;
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    objectOutputStream.writeObject(myStr);


}
    }
}