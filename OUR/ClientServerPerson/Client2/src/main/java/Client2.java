import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Client2 {
    public static void main(String[] args) {
        Person2 person2=new Person2();
        Gson gson=new Gson();
        Faker faker=new Faker();
        person2.setName(faker.name().firstName());
        person2.setLastName(faker.name().lastName());
        person2.setPhoneNumber(faker.phoneNumber().phoneNumber());
        person2.setEmail(faker.internet().emailAddress());
        person2.setAddress(faker.address().fullAddress());
        person2.setAge(String.valueOf(new Random().nextInt(100)));

        try {
            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
              String uxarkvox=gson.toJson(person2);
              objectOutputStream.writeObject(uxarkvox);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
