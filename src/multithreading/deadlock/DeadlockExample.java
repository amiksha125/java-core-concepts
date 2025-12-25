package multithreading.deadlock;


class Pen {

    //thread 1 has pen, below method will acquire lock by pen object
    // then it calls paper.finishWriting(), It wants lock of paper now, It has pen lock now it also wants paper's lock
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen "+ this + " and trying ");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen "+ this);
    }
}

class Paper{
    // thread 2 has paper's lock and trying to acquire pen's lock by calling pen.finishWriting()
    //They are dependent on each other

    // There are multiple strategies to overcome deadlock
    // 1. Ensure all the threads must acquire locks in a consistent order.
    //These two classes are fine, we need to change both the tasks.
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper "+ this + " and trying ");
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using paper "+ this);
    }

}

class Task1 implements Runnable{
    private final Pen pen;

    private final Paper paper;

    public Task1(Pen pen, Paper paper){
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // thread 1 locks pen and try to lock paper
    }
}

class Task2 implements Runnable{
    private final Pen pen;

    private final Paper paper;

    public Task2(Pen pen, Paper paper){
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        /* Solution:
        //solve deadlock by one synchronized block to ensure thread 2 applied lock on paper when the pen lock is available
        // after thread 1 finish and pen lock is released, then only thread 2 will start */
        synchronized (pen){
            paper.writeWithPaperAndPen(pen);
        }
       // paper.writeWithPaperAndPen(pen);// thread 2 locks paper and tries to lock pen
    }
}
public class DeadlockExample {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread t2 = new Thread(new Task2(pen, paper), "Thread-2");

        t1.start();
        t2.start();


        // This code will keep running , we ' ll forcefully stop it
    }

}
