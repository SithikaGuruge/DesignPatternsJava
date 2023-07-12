package ProtoType;

class Robot implements Cloneable{
    private String name;
    private String func;
    private int legs;

    public Robot(String name, String func, int legs) {
        this.name = name;
        this.func = func;
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public Robot clone() throws CloneNotSupportedException {
        return (Robot) super.clone();
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", func='" + func + '\'' +
                ", legs=" + legs +
                '}';
    }
}


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Robot robot1 = new Robot("AAA","Speak",5);
        Robot robot2 = robot1.clone();
        robot2.setName("BBB");
        robot2.setLegs(10);
        System.out.println(robot1);
        System.out.println(robot2);
        robot1.setName("Nimal");
        System.out.println(robot1);
        System.out.println(robot2);

    }


}
