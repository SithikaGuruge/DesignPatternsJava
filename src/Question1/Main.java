package Question1;

class Class1 {
    private int count = 1;
    private final Object lock = new Object();
    private boolean isCookingDone = false;

    public void setCount(int count) {
        synchronized (lock) {
            this.count = count;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }

    public boolean isCookingDone() {
        synchronized (lock) {
            return isCookingDone;
        }
    }

    public void setCookingDone(boolean cookingDone) {
        synchronized (lock) {
            isCookingDone = cookingDone;
        }
    }
}

class Cooker1 implements Runnable {
    Class1 obj;

    public Cooker1(Class1 obj) {
        this.obj = obj;
        Thread t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (obj.getCount() < 3 && !obj.isCookingDone()) {
                    System.out.println("Cooked popcorn " + obj.getCount());
                    obj.setCount(obj.getCount() + 1);
                } else {
                    obj.setCookingDone(true);
                    obj.notifyAll();
                    break;
                }
            }
        }
    }
}

class Cooker2 implements Runnable {
    Class1 obj;

    public Cooker2(Class1 obj) {
        this.obj = obj;
        Thread t2 = new Thread(this);
        t2.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (obj.getCount() < 3 && !obj.isCookingDone()) {
                    System.out.println("Cooked popcorn__" + obj.getCount());
                    obj.setCount(obj.getCount() + 1);
                } else {
                    obj.setCookingDone(true);
                    obj.notifyAll();
                    break;
                }
            }
        }
    }
}

class RoboArm implements Runnable {
    Class1 obj;

    public RoboArm(Class1 obj) {
        this.obj = obj;
        Thread t3 = new Thread(this);
        t3.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (obj.getCount() > 0 && obj.isCookingDone()) {
                    System.out.println("Got popcorn " + obj.getCount());
                    obj.setCount(obj.getCount() - 1);
                } else if (obj.getCount() == 0 && obj.isCookingDone()) {
                    obj.setCookingDone(false);
                    obj.notifyAll();
                    break;
                } else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Cooker1 cooker1 = new Cooker1(class1);
        Cooker2 cooker2 = new Cooker2(class1);
        RoboArm roboArm = new RoboArm(class1);
    }
}