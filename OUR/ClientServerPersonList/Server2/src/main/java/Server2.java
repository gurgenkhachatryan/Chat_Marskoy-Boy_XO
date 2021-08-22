import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server2 {
    public static void main(String[] args) {
Person2 person2=new Person2();
        Gson gson=new Gson();
        File file=new File("csvfile2.csv");


        try {
            file.createNewFile();
            ServerSocket serverSocket=new ServerSocket(8080);
            Socket socket= serverSocket.accept();


            InputStream inputStream=socket.getInputStream();
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
           Person2[] pers= gson.fromJson((String) objectInputStream.readObject(),Person2[].class);
            System.out.println(Arrays.toString(pers));
            CSVPrinter csvPrinter=new CSVPrinter(new FileWriter(file), CSVFormat.DEFAULT.withHeader("Name","LastName","PhoneNumber","email","address","age"));

            Arrays.stream(pers)
                    .forEach(p-> {

                        try {
                            csvPrinter.printRecord(p.getName(),p.getLastname(),
                                    p.getPhoneNumber(),p.getEmail(),p.getAddress(),p.getAge());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });
            //objectInputStream.readObject();
            csvPrinter.flush();



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
