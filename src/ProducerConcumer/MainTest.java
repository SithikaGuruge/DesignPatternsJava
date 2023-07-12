package ProducerConcumer;
public class MainTest {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        new Producer(class1);
        new Consumer(class1);
    }
}
class Class1{
    int num;
    boolean valueSet = false;
    public synchronized void getNum() {
        while (!valueSet){
            try{wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Get :" + num);
        valueSet = false;
        notify();
    }
    public synchronized void setNum(int num) {
        while (valueSet){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Set :" + num);
        this.num = num;
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable{
    Class1 object;
    public Producer(Class1 object){
        this.object = object;
        Thread t = new Thread(this, "Producer");
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while (true){
            object.setNum(i++);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    Class1 object;
    public Consumer(Class1 object){
        this.object = object;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while (true){
            object.getNum();
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}