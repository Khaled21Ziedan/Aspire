package Assingment7;

public class ThreadsTest {
    public static void main(String[] args) {

        Thread thread1 = new Thread(1);
        Thread thread2 = new Thread(2);
        Thread thread3 = new Thread(3);

        java.lang.Thread t1 = new java.lang.Thread(thread1);
        java.lang.Thread t2 = new java.lang.Thread(thread2);
        java.lang.Thread t3 = new java.lang.Thread(thread3);

        t1.start();
        t2.start();
        t3.start();
    }
}
