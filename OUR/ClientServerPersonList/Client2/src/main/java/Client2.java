import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client2 {
    public static void main(String[] args) {
        Faker faker=new Faker();
        Gson gson=new Gson();

        List<Person2> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person2 person2=new Person2();
            person2.setName(faker.name().name());
            person2.setLastName(faker.name().lastName());
            person2.setPhoneNumber(faker.phoneNumber().phoneNumber());
            person2.setEmail(faker.internet().emailAddress());
            person2.setAddress(faker.address().fullAddress());
            person2.setAge(String.valueOf(new Random().nextInt(100)));
        list.add(person2);
        }
        String uxarkvox=gson.toJson(list);


        try {
            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(uxarkvox);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
