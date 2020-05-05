import com.sun.tools.javac.Main;

import java.util.Random;

public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
//        Main1 m = new Main1();
        while (runDistance < Main1.DISTANCE) {
            try {
                int speed = (new Random()).nextInt(20);
                runDistance += speed;
                // Build result graphic
                String log = "|";
                int percentTravel = (runDistance * 100) / Main1.DISTANCE;
                for (int i = 0; i < Main1.DISTANCE; i += Main1.STEP) {
                    if (percentTravel >= i + Main1.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main1.STEP) {
//                        log += "o";
                        log += this.name + ">";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(Main1.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
