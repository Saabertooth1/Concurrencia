public class CC_01_Threads extends Thread{

    private int identifier;

    private CC_01_Threads (int i){
        this.identifier = i;
    }

    public static void main(String[] args) {
        int maxThreads = 10;

        CC_01_Threads Threads[] = new CC_01_Threads[maxThreads];

        for (int i = 0; i < maxThreads; i++){
            Threads[i] = new CC_01_Threads(i);
            Threads[i].start();
        }

        for (int j = 0; j < maxThreads; j++){
            try {
                Threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All Threads have ended");
    }

    public void run(){
        System.out.println("Hello from Thread " + identifier);
        int t = 3000;

        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + identifier + " has ended");
    }
}
