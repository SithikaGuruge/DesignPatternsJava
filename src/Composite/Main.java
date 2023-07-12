package Composite;

import java.util.Vector;

interface Component{
    public void getvalue();
}
class Leaf implements Component{
    private String name;
    private int value;
    public Leaf(String name, int value){
        this.name = name;
        this.value = value;
    }
    @Override
    public void getvalue() {
        System.out.println(this.name+" : " + this.value);
    }
}
class Composite implements Component{
    private String name;
    private Vector<Component> components;
    public Composite(String name){
        this.name = name;
        components = new Vector<Component>();
    }

    public void add(Component c2){
        components.add(c2);
    }
    @Override
    public void getvalue() {
        System.out.println(name);
        for(Component c : components ){
            c.getvalue();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Leaf l1 = new Leaf("Mouse",100);
        Leaf l2 = new Leaf("Keyboard",200);
        Leaf l3 = new Leaf("processor",3000);
        Leaf l4 = new Leaf("Ram",1500);

        Composite c1 = new Composite("Motherboard");
        Composite c2 = new Composite("Computer");

        c1.add(l3);
        c1.add(l4);
        c2.add(c1);
        c2.add(l1);
        c2.add(l2);

        c2.getvalue();

    }
}
