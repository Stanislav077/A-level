import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
MultiTheding multiTheding = new MultiTheding();
        Thread thread = new Thread(multiTheding);
        thread.start();
        Scanner in = new Scanner(System.in);

                while(thread.isAlive()){
                    int bam = in.nextInt();
                multiTheding.adds();
            }

        in.close();





    }
}
