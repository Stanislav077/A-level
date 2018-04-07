import java.util.Scanner;

/**
 * Created by Станислав on 07.04.2018.
 */
public class MultiTheding implements Runnable {
    private int interval = 10;
    private int intervalstep = 10;
    @Override
    public void run() {



        while (!lose()) {
            try {
                System.out.println("bamm");

                Thread.sleep(2000);
                describlaFattarns();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("You Lose!!!");
    }
    private boolean lose(){

return (interval<=0);

    }
    public void describlaFattarns(){
        interval -= intervalstep;

    }
public  void adds(){
    interval += 10;
    System.out.println(interval);
}


}
