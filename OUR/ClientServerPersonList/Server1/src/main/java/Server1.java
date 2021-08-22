import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server1 {
    public static void main(String[] args) {
        File file=new File("csvfile.csv");

        Person1 person1=new Person1();
        Gson gson=new Gson();
        try {
            file.createNewFile();
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket= serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
Person1[] pers=gson.fromJson((String) objectInputStream.readObject(),Person1[].class);
CSVPrinter csvPrinter=new CSVPrinter(new FileWriter(file), CSVFormat.DEFAULT.withHeader("Name","LastName","PhoneNumber","Email","address","age"));
Arrays.stream(pers)
        .forEach(p-> {
            try {
                csvPrinter.printRecord(p.name,p.lastName,p.phoneNumber,p.email,p.address,p.age);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
            System.out.println(Arrays.toString(pers));
            csvPrinter.flush();



        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
