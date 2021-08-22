import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client1 {
    public static void main(String[] args) {
        Gson gson=new Gson();
        Faker faker=new Faker();

        List<Person1> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person1 person1=new Person1();
person1.name=faker.name().name();
person1.lastName=faker.name().lastName();
person1.phoneNumber=faker.phoneNumber().phoneNumber();
person1.email=faker.internet().emailAddress();
person1.address=faker.address().fullAddress();
person1.age=String.valueOf(new Random().nextInt(100));
list.add(person1);
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
