package Assingment7;
public class Thread implements Runnable{
        private int threadNumber ;

    public Thread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
        public void run() {
            System.out.println("Thread"+threadNumber+" is running");
        }
    }
