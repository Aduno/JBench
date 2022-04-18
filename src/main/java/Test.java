import java.util.concurrent.TimeUnit;

public class Test {
    public static void func1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void func2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void func3(){
        try {
            TimeUnit.NANOSECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }public static void func4(){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
