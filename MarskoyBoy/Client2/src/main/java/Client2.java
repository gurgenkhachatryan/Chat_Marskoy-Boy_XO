import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client2 {
    static int n1 = 1, m1 = 1;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Socket socket = new Socket("localHost", 8080);
        Random random = new Random();
        String[][] matrix = new String[12][12];
        String[][] yourMatrix = new String[12][12];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                matrix[i][j] = "*";
            }
        }
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                yourMatrix[i][j] = "*";
            }
        }


        int cucichfour = random.nextInt(3);

        if (cucichfour == 1) {
            int iFour = 1 + random.nextInt(7);
            int jFour = 1 + random.nextInt(10);
            for (int i = iFour - 1; i <= iFour + 4; i++) {
                for (int j = jFour - 1; j <= jFour + 1; j++) {
                    matrix[i][j] = ".";
                }
            }
            for (int i = 0; i < 4; i++) {
                matrix[iFour][jFour] = "#";
                iFour++;
            }
        } else {
            int iFour = 1 + random.nextInt(10);
            int jFour = 1 + random.nextInt(7);
            for (int i = iFour - 1; i <= iFour + 1; i++) {
                for (int j = jFour - 1; j <= jFour + 4; j++) {
                    matrix[i][j] = ".";
                }
            }
            for (int i = 0; i < 4; i++) {
                matrix[iFour][jFour] = "#";
                jFour++;
            }
        }

        for (int k = 0; k < 2; k++) {
            int cucichThree = random.nextInt(3);
            if (cucichThree == 1) {
                int iThree = 1 + random.nextInt(8);
                int jThree = 1 + random.nextInt(10);

                while (matrix[iThree][jThree] == "." || matrix[iThree][jThree] == "#"
                        || matrix[iThree + 1][jThree] == "." || matrix[iThree + 1][jThree] == "#"
                        || matrix[iThree + 2][jThree] == "." || matrix[iThree + 2][jThree] == "#") {
                    iThree = 1 + random.nextInt(8);
                    jThree = 1 + random.nextInt(10);
                }
                for (int i = iThree - 1; i <= iThree + 3; i++) {
                    for (int j = jThree - 1; j <= jThree + 1; j++) {
                        matrix[i][j] = ".";
                    }
                }
                for (int i = 0; i < 3; i++) {
                    matrix[iThree][jThree] = "#";
                    iThree++;
                }
            } else {

                int iThree = 1 + random.nextInt(10);
                int jThree = 1 + random.nextInt(8);
                while (matrix[iThree][jThree] == "." || matrix[iThree][jThree] == "#"
                        || matrix[iThree][jThree + 1] == "." || matrix[iThree][jThree + 1] == "#"
                        || matrix[iThree][jThree + 2] == "." || matrix[iThree][jThree + 2] == "#") {
                    iThree = 1 + random.nextInt(10);
                    jThree = 1 + random.nextInt(8);
                }
                for (int i = iThree - 1; i <= iThree + 1; i++) {
                    for (int j = jThree - 1; j <= jThree + 3; j++) {
                        matrix[i][j] = ".";
                    }
                }
                for (int i = 0; i < 3; i++) {
                    matrix[iThree][jThree] = "#";
                    jThree++;
                }

            }
        }
        for (int k = 0; k < 3; k++) {
            int cucichTwo = random.nextInt(3);
            if (cucichTwo == 1) {
                int iTwo = 1 + random.nextInt(9);
                int jTwo = 1 + random.nextInt(10);
                while (matrix[iTwo][jTwo] == "." || matrix[iTwo][jTwo] == "#"
                        || matrix[iTwo + 1][jTwo] == "." || matrix[iTwo + 1][jTwo] == "#") {
                    iTwo = 1 + random.nextInt(9);
                    jTwo = 1 + random.nextInt(10);
                }
                for (int i = iTwo - 1; i <= iTwo + 2; i++) {
                    for (int j = jTwo - 1; j <= jTwo + 1; j++) {
                        matrix[i][j] = ".";
                    }
                }
                for (int i = 0; i < 2; i++) {
                    matrix[iTwo][jTwo] = "#";
                    iTwo++;
                }

            } else {
                int iTwo = 1 + random.nextInt(10);
                int jTwo = 1 + random.nextInt(9);
                while (matrix[iTwo][jTwo] == "." || matrix[iTwo][jTwo] == "#"
                        || matrix[iTwo][jTwo + 1] == "." || matrix[iTwo][jTwo + 1] == "#") {
                    iTwo = 1 + random.nextInt(10);
                    jTwo = 1 + random.nextInt(9);
                }
                for (int i = iTwo - 1; i <= iTwo + 1; i++) {
                    for (int j = jTwo - 1; j <= jTwo + 2; j++) {
                        matrix[i][j] = ".";
                    }
                }
                for (int i = 0; i < 2; i++) {
                    matrix[iTwo][jTwo] = "#";
                    jTwo++;
                }
            }
        }
        for (int k = 0; k < 4; k++) {
            int iOne = 1 + random.nextInt(10);
            int jOne = 1 + random.nextInt(10);
            while (matrix[iOne][jOne] == "." || matrix[iOne][jOne] == "#") {
                iOne = 1 + random.nextInt(10);
                jOne = 1 + random.nextInt(10);
            }
            for (int i = iOne - 1; i <= iOne + 1; i++) {
                for (int j = jOne - 1; j <= jOne + 1; j++) {
                    matrix[i][j] = ".";
                }
            }
            matrix[iOne][jOne] = "#";
        }
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (matrix[i][j] != "#")
                    matrix[i][j] = ".";
            }
        }
        System.out.println("\n              MY MATRIX");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                System.out.print("" + i + " ");
                for (int j = 1; j <= 10; j++) {
                    System.out.print(" " + matrix[i][j] + " ");
                }
                System.out.println();
            } else {
                System.out.print(" " + i + " ");
                for (int j = 1; j <= 10; j++) {

                    System.out.print(" " + matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("\n\n            YOUR MATRIX");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            if (i == 10) {
                System.out.print("" + i + " ");
                for (int j = 1; j <= 10; j++) {
                    System.out.print(" " + yourMatrix[i][j] + " ");
                }
                System.out.println();
            } else {
                System.out.print(" " + i + " ");
                for (int j = 1; j <= 10; j++) {

                    System.out.print(" " + yourMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        Runnable task1 = () ->
        {
            try {
                while (true) {
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    String in = (String) objectInputStream.readObject();
                    if (in.charAt(0) == 'v') {
                        n1 = Integer.parseInt(String.valueOf(in.charAt(1)));
                        m1 = Integer.parseInt(String.valueOf(in.charAt(2)));
                        yourMatrix[n1][m1] = "X";
                        arrayList.add(n1);
                        arrayList.add(m1);
                    } else if (in.charAt(0) == 'm') {
                        n1 = Integer.parseInt(String.valueOf(in.charAt(1)));
                        m1 = Integer.parseInt(String.valueOf(in.charAt(2)));
                        arrayList.add(n1);
                        arrayList.add(m1);
                        yourMatrix[n1][m1] = "X";
                        int n1old = arrayList.get(0);
                        int m1old = arrayList.get(1);
                        int n1end = arrayList.get(arrayList.size() - 2);
                        int m1end = arrayList.get(arrayList.size() - 1);
                        System.out.println("arraylist=" + arrayList);

                        if (n1old == n1end) {
                            int m1oldold = m1old;
                            for (int j = 0; j < arrayList.size() / 2 + 2; j++) {
                                yourMatrix[n1old - 1][m1old - 1] = ".";
                                yourMatrix[n1old + 1][m1old - 1] = ".";
                                m1old++;
                            }
                            yourMatrix[n1old][m1oldold - 1] = ".";
                            yourMatrix[n1old][m1end + 1] = ".";
                        } else {
                            int n1oldold = n1old;
                            for (int i = 0; i < arrayList.size() / 2 + 2; i++) {
                                yourMatrix[n1old - 1][m1old - 1] = ".";
                                yourMatrix[n1old - 1][m1old + 1] = ".";
                                n1old++;
                            }
                            yourMatrix[n1oldold - 1][m1old] = ".";
                            yourMatrix[n1end + 1][m1old] = ".";
                        }

                    } else {
                      //  yourMatrix[n1][m1] = "O";
                        n1 = Integer.parseInt(String.valueOf(in.charAt(0)));
                        m1 = Integer.parseInt(String.valueOf(in.charAt(2)));
                        if (matrix[n1][m1] == "#") {
                            matrix[n1][m1] = "X";
                        }
                    }

                    System.out.println("\n              MY MATRIX");
                    System.out.println();
                    System.out.print("    ");
                    for (int i = 1; i <= 10; i++) {
                        System.out.print(i + "  ");
                    }
                    System.out.println();
                    for (int i = 1; i <= 10; i++) {
                        if (i == 10) {
                            System.out.print("" + i + " ");
                            for (int j = 1; j <= 10; j++) {
                                System.out.print(" " + matrix[i][j] + " ");
                            }
                            System.out.println();
                        } else {
                            System.out.print(" " + i + " ");
                            for (int j = 1; j <= 10; j++) {

                                System.out.print(" " + matrix[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }

                    System.out.println("\n\n            YOUR MATRIX");
                    System.out.println();
                    System.out.print("    ");
                    for (int i = 1; i <= 10; i++) {
                        System.out.print(i + "  ");
                    }
                    System.out.println();
                    for (int i = 1; i <= 10; i++) {
                        if (i == 10) {
                            System.out.print("" + i + " ");
                            for (int j = 1; j <= 10; j++) {
                                System.out.print(" " + yourMatrix[i][j] + " ");
                            }
                            System.out.println();
                        } else {
                            System.out.print(" " + i + " ");
                            for (int j = 1; j <= 10; j++) {

                                System.out.print(" " + yourMatrix[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }

   //                 arrayList.clear();
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

        };

        Runnable task2 = () ->
        {
            try {
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    String out = scanner.nextLine();
                    if (out.equals("v") || out.equals("m")) {
                        String k = String.valueOf(n1);
                        String q = String.valueOf(m1);
                        out = out + k + q;
                        objectOutputStream.writeObject(out);
                    } else {
                        int n1 = Integer.parseInt(String.valueOf(out.charAt(0)));
                        int m1 = Integer.parseInt(String.valueOf(out.charAt(2)));

                        while (n1 < 1 || n1 > 10 || m1 < 1 || m1 > 10 || out.charAt(1) != ':' ||
                                out.length() != 3 || yourMatrix[n1][m1] == "." || yourMatrix[n1][m1] == "X") {
                            System.out.println("invalid text");
                            out = scanner.nextLine();
                        }
                        yourMatrix[n1][m1]="O";
                        objectOutputStream.writeObject(out);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        };
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();


    }
}
/*


//        Runnable task1 = () ->
//        {
//            try {
//                while (true) {
//                    InputStream inputStream = socket.getInputStream();
//                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//                    String in = (String) objectInputStream.readObject();
//                    if (in != null) {
//                        char ch=in.charAt(0);
//                        if(ch=='W'||ch=='S')
//                        {
//                            yourMatrix[q][w]="X";
//                        }
//                        else if(ch=='D')
//                        {
//                            yourMatrix[q][w]=".";
//                        }
//
//                        int i = Integer.parseInt(String.valueOf(in.charAt(0)));
//                        int j = Integer.parseInt(String.valueOf(in.charAt(2)));
//
//                        if (matrix[i][j] == "#") {
//                            //         navka.set(true);
//                            matrix[i][j] = "X";
//                      /*       if (matrix[i][j - 1] == "#" || matrix[i][j + 1] == "#" ||
//                                     matrix[i - 1][j] == "#" || matrix[i + 1][j] == "#") {
////                                 viravor.set(true);
////                             } else {
////                                 merav.set(true);
////                            }
////
////
//                                 System.out.println("voravor");
//                             }
//                             else {
//                                 System.out.println("merav");
//                             }
//
//                        } else {
//                            matrix[i][j] = ".";
//                            System.out.println("ban chkar");
//                        }
//                    }
//                    System.out.println("\n              MY MATRIX");
//                    System.out.println();
//                    System.out.print("    ");
//                    for (int i = 1; i <= 10; i++) {
//                        System.out.print(i + "  ");
//                    }
//                    System.out.println();
//                    for (int i = 1; i <= 10; i++) {
//                        if (i == 10) {
//                            System.out.print("" + i + " ");
//                            for (int j = 1; j <= 10; j++) {
//                                System.out.print(" " + matrix[i][j] + " ");
//                            }
//                            System.out.println();
//                        } else {
//                            System.out.print(" " + i + " ");
//                            for (int j = 1; j <= 10; j++) {
//
//                                System.out.print(" " + matrix[i][j] + " ");
//                            }
//                            System.out.println();
//                        }
//                    }
//
//                                /*
//
//                            }
//                            System.out.println("WOUNDED ");
//                            System.out.println("CLIENT 2:\n ");
//                        } else {
//                            System.out.print("    ");
//                            for (int k = 1; k <= 10; k++) {
//                                System.out.print(k + "  ");
//                            }
//                            System.out.println();
//                            for (int k = 1; k <= 10; k++) {
//                                if (k == 10) {
//                                    System.out.print("" + k + " ");
//                                    for (int l = 1; l <= 10; l++) {
//                                        System.out.print(" " + yourMatrix[k][l] + " ");
//                                    }
//                                    System.out.println();
//                                } else {
//                                    System.out.print(" " + k + " ");
//                                    for (int l = 1; l <= 10; l++) {
//
//                                        System.out.print(" " + yourMatrix[k][l] + " ");
//                                    }
//                                    System.out.println();
//                                }
//                            }
//                        }
//
//
//                        else{
//
//                            matrix[i][j] = "O";
//                            for (int k = 1; k <= 10; k++) {
//                                System.out.print("  " + k + "");
//                            }
//                            System.out.println();
//                            for (int l = 1; l <= 10; l++) {
//                                System.out.print(l);
//                                for (int o = 1; o <= 10; o++) {
//
//                                    System.out.print(" " + matrix[l][o] + " ");
//                                }
//                                System.out.println();
//                            }
//                            System.out.println("DID NOT TOUCH");
//                            System.out.println("\nCLIENT 2:");
//
//
//                            }*/
//                        }
//
//
//
//
//
//            } catch (ClassNotFoundException | IOException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Runnable task2 = () ->
//        {
//            try {
//                while (true) {
//                    OutputStream outputStream = socket.getOutputStream();
//                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//                    String out = scanner.nextLine();
//            /*        String patasxan;
//                    if(navka.get()==true)
//                    {
//                        if (viravor.get()==true)
//                        {
//                             patasxan="WOUNDED";
//                        }
//                        else  patasxan="SANK";
//                    }
//                    else {
//                        patasxan="DID NOT TOUCH";
//                    }
//                    objectOutputStream.writeObject(patasxan);*/
//                    int n1=Integer.parseInt(String.valueOf(out.charAt(0)));
//                    int m1=Integer.parseInt(String.valueOf(out.charAt(2)));
//               /*     while (n1<1 || n1>10 || m1<1 || m1>10 || out.charAt(1)!=':' ||
//                            out.length()!=3 || yourMatrix[n1][m1]!="."|| yourMatrix[n1][m1]!="X"){
//                        System.out.println("invalid text");
//              //      q=n1;
//               //     w=m1;
//                        out= scanner.nextLine();}*/
//                    objectOutputStream.writeObject(out);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };
//        executorService.execute(task1);
//        executorService.execute(task2);
//        executorService.shutdown();
//
//
//    }
//}
