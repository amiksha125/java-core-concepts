package multithreading.thread_communication;

class SharesResouces{
    private int data;

    private boolean hasData;

    //producer will produce only when hasData is false or data is unavailable
    public synchronized void produce(int value){

        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                //restore its state if interrupted
                Thread.currentThread().interrupt();
            }
        }

        data = value;
        hasData = true;
        System.out.println("Produced "+ value);
        notify(); // the thread waiting to access resource is now allowed to access

    }

    //consumer will consume only when hasData is true or data is available
    public synchronized int consume(){
        while(!hasData){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false; // producer can start producing now
        System.out.println("Consumed "+ data);
        notify();
        return data;
    }
}

class Producer implements Runnable{
    private SharesResouces resource;

    public Producer(SharesResouces resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharesResouces resource;

    public Consumer(SharesResouces resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            int value = resource.consume();
        }
    }
}


public class ThreadCommunication {
    public static void main(String[] args) {

        SharesResouces resouces = new SharesResouces();
        Thread producer = new Thread(new Producer(resouces));
        Thread consumer = new Thread(new Consumer(resouces));

        producer.start();
        consumer.start();

    }
}
