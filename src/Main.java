import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        myThread thread = new myThread();
        thread.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        thread.off();

        System.out.println("Hello world!");
    }
    static class myThread extends Thread {
        private volatile boolean runn = true; // volatile используется что бы у разных потоков была одинаковая версия переменной
        public void run(){
            while (runn){
                System.out.println("thread . . . .");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        public void off(){
            this.runn = false;
        }
    }
}