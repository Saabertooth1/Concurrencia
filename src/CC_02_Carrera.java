public class CC_02_Carrera {

    static int counter = 0;

    static class Incrementador extends Thread{

        public void run(){
            counter++;
        }
    }

    static class Decrementador extends Thread{

        public void run() {
            counter--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int maxThreads = 15;

        Thread IncrementadorArray[] = new Thread[maxThreads];
        Thread DecrementadorArray[] = new Thread[maxThreads];

        for (int i = 0; i < maxThreads; i++){
            IncrementadorArray[i] = new Incrementador();
            DecrementadorArray[i] = new Decrementador();
            IncrementadorArray[i].start();
            DecrementadorArray[i].start();
        }

        for (int i = 0; i < maxThreads; i++){
            IncrementadorArray[i].join();
            DecrementadorArray[i].join();

        }

        System.out.println(counter);


    }


}
