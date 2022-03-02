import java.util.Random;

public class Car implements Runnable{
    public static final int DISTANCE = 100;
    public static final int STEP = 2;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance =0;
        long startTime = System.currentTimeMillis();
        while(runDistance< DISTANCE){
            try {
                int speed = ((new Random()).nextInt(20));
                runDistance+=speed;
                String log ="|";
                int percentTraveled = (runDistance*100)/DISTANCE;
                for (int i = 0; i < DISTANCE; i+= STEP) {
                    if(percentTraveled>=i+STEP){
                        log+="=";
                    }
                    else if(percentTraveled>= i && percentTraveled< i + STEP){
                        log+="o";
                    }
                    else {log+="-";}
                }
                log+="|";
                System.out.println("Car "+ name + log + " "+ Math.min(DISTANCE,runDistance)+ "Km!");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Car "+ name +" broken!");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car "+ name + " finish in "+ (endTime-startTime)/1000+"s");
    }
}
