import com.github.javafaker.Faker;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Client1 {
    public static void main(String[] args) {
        Gson gson=new Gson();
        Faker faker=new Faker();
        try {
            Person1 person1=new Person1();
            person1.setName(faker.name().firstName());
            person1.setSurname(faker.name().lastName());
            person1.setPhoneNumber(faker.phoneNumber().phoneNumber());
            person1.setEmail(faker.internet().emailAddress());
            person1.setAddress(faker.address().fullAddress());
person1.setAge(String.valueOf(new Random().nextInt(100)));

            Socket socket=new Socket("localHost",8080);
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            String uxarkel=gson.toJson(person1);
            objectOutputStream.writeObject(uxarkel);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
