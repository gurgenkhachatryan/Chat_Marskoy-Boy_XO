import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client1 {

    public static void main(String[] args) throws IOException {
         String [][] matrix=new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]=".";
            }
        }
        Socket socket = new Socket("localHost", 8080);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);


        Runnable task1 = (() ->
        {

            try {
                while (true) {
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    String str1=(String) objectInputStream.readObject();

                    if (str1 != null) {
                        System.out.println("CLIENT 2: ");
                        int n=Integer.parseInt(String.valueOf(str1.charAt(0)));
                        int m=Integer.parseInt(String.valueOf(str1.charAt(2)));
                        matrix[n][m]="O";
                        for(int i=0;i<3;i++)
                        {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println();
                        }
                        if((matrix[0][0]=="X" && matrix[0][1]=="X" && matrix[0][2]=="X")||(matrix[1][0]=="X" && matrix[1][1]=="X" && matrix[1][2]=="X")||(matrix[2][0]=="X" && matrix[2][1]=="X" && matrix[2][2]=="X")
                                ||(matrix[0][0]=="X" && matrix[1][0]=="X" && matrix[2][0]=="X")||(matrix[0][1]=="X" && matrix[1][1]=="X" && matrix[2][1]=="X")||(matrix[0][2]=="X" && matrix[1][2]=="X" && matrix[2][2]=="X")
                                ||(matrix[0][0]=="X" && matrix[1][1]=="X" && matrix[2][2]=="X")||(matrix[0][2]=="X" && matrix[1][1]=="X" && matrix[2][0]=="X"))
                        {System.out.println("WINNER CLIENT 1");

                            System.out.println("NEW GAME");
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    matrix[i][j]=".";
                                }
                            };}
                        else if((matrix[0][0]=="O" && matrix[0][1]=="O" && matrix[0][2]=="O")||(matrix[1][0]=="O" && matrix[1][1]=="O" && matrix[1][2]=="O")||(matrix[2][0]=="O" && matrix[2][1]=="O" && matrix[2][2]=="O")
                                ||(matrix[0][0]=="O" && matrix[1][0]=="O" && matrix[2][0]=="O")||(matrix[0][1]=="O" && matrix[1][1]=="O" && matrix[2][1]=="O")||(matrix[0][2]=="O" && matrix[1][2]=="O" && matrix[2][2]=="O")
                                ||(matrix[0][0]=="O" && matrix[1][1]=="O" && matrix[2][2]=="O")||(matrix[0][2]=="O" && matrix[1][1]=="O" && matrix[2][0]=="O"))
                        {
                            System.out.println("WINNER CLIENT 2");

                            System.out.println("NEW GAME");
                           // String [][] matrix1=new String[3][3];
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    matrix[i][j]=".";
                                }
                            }
                        }
                        System.out.print("\nCLIENT 1: \n");


                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        });


        Runnable task2 = (() ->
        {
            try {
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    String out = scanner.nextLine();

                    int n1=Integer.parseInt(String.valueOf(out.charAt(0)));
                    int m1=Integer.parseInt(String.valueOf(out.charAt(2)));
                    while (n1<0 || n1>2 || m1<0 || m1>2 || out.charAt(1)!=':' ||
                            out.length()!=3 || matrix[n1][m1]!=".") {
                        System.out.println("invalid text");
                        out= scanner.nextLine();
                        n1=Integer.parseInt(String.valueOf(out.charAt(0)));
                         m1=Integer.parseInt(String.valueOf(out.charAt(2)));}
                        matrix[n1][m1] = "X";
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println();
                        }



                    if((matrix[0][0]=="X" && matrix[0][1]=="X" && matrix[0][2]=="X")||(matrix[1][0]=="X" && matrix[1][1]=="X" && matrix[1][2]=="X")||(matrix[2][0]=="X" && matrix[2][1]=="X" && matrix[2][2]=="X")
                        ||(matrix[0][0]=="X" && matrix[1][0]=="X" && matrix[2][0]=="X")||(matrix[0][1]=="X" && matrix[1][1]=="X" && matrix[2][1]=="X")||(matrix[0][2]=="X" && matrix[1][2]=="X" && matrix[2][2]=="X")
                        ||(matrix[0][0]=="X" && matrix[1][1]=="X" && matrix[2][2]=="X")||(matrix[0][2]=="X" && matrix[1][1]=="X" && matrix[2][0]=="X"))
                    {System.out.println("WINNER CLIENT 1");
                        objectOutputStream.writeObject(out);
                        System.out.println("NEW GAME");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                matrix[i][j]=".";
                            }
                        };}
                    else if((matrix[0][0]=="O" && matrix[0][1]=="O" && matrix[0][2]=="O")||(matrix[1][0]=="O" && matrix[1][1]=="O" && matrix[1][2]=="O")||(matrix[2][0]=="O" && matrix[2][1]=="O" && matrix[2][2]=="O")
                            ||(matrix[0][0]=="O" && matrix[1][0]=="O" && matrix[2][0]=="O")||(matrix[0][1]=="O" && matrix[1][1]=="O" && matrix[2][1]=="O")||(matrix[0][2]=="O" && matrix[1][2]=="O" && matrix[2][2]=="O")
                            ||(matrix[0][0]=="O" && matrix[1][1]=="O" && matrix[2][2]=="O")||(matrix[0][2]=="O" && matrix[1][1]=="O" && matrix[2][0]=="O"))
                    {
                        System.out.println("WINNER CLIENT 2");
                        objectOutputStream.writeObject(out);
                        System.out.println("NEW GAME");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                matrix[i][j]=".";
                            }
                        }
                    }
                    objectOutputStream.writeObject(out);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();
    }
}
