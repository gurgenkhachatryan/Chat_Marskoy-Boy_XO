import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {

           Socket socket = new Socket("localHost", 8080);

        while (true) {
            try {

                OutputStream outputStream = socket.getOutputStream();

                Scanner scanner = new Scanner(System.in);
                String uxarkvox= scanner.nextLine();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(uxarkvox);
                if(uxarkvox.equals(" de helanq"))
                {
                    break;
                }


                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String Serveric_Stacvac = (String) objectInputStream.readObject();
                System.out.println(Serveric_Stacvac);
                if (Serveric_Stacvac.equals("de helanq")) {
                    break;
                }

            } catch (IOException  | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
