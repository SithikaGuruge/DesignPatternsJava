package Singleton;

class Singleton{
    private String name;
    private static  volatile Singleton singleton;
    private Singleton(String name){
        this.name = name;
    }
    public static Singleton getInstance(String name){
        if(singleton==null){
            synchronized (Singleton.class)
            {
                singleton = new Singleton(name);
            }
        }
        return singleton;
    }
    public void getName(){
        System.out.println(name);
    }

}

public class Main {

    public static void main(String[] args) {
        Singleton sin1 = Singleton.getInstance("Kamal");
        sin1.getName();

        Singleton sin2 = Singleton.getInstance("Namal");
        sin2.getName();

    }
}