public class StrategyMain {
    public static void main(String[] args) {
        Duck normalDuck = new Duck(new SimpleQuack(), new SimpleFly(), new NormalDisplay());
        normalDuck.quack();
        normalDuck.fly();
        normalDuck.display();

        Duck fakeDuck = new Duck(new NoQuack(), new NoFly(), new NoDuckDisplay());
        fakeDuck.quack();
        fakeDuck.fly();
        fakeDuck.display();
    }
}

interface IQuack{
    void quack();
}
class SimpleQuack implements IQuack{
    @Override
    public void quack() {
        System.out.println("Simple Quack");
    }
}
class NoQuack implements IQuack{
    @Override
    public void quack() {
        System.out.println("No Quack");
    }
}
class SpecialQuack implements IQuack{
    @Override
    public void quack() {
        System.out.println("Special Quack");
    }
}

interface IFly{
    void fly();
}
class SimpleFly implements IFly{
    @Override
    public void fly() {
        System.out.println("Simple Fly");
    }
}
class NoFly implements IFly{
    @Override
    public void fly() {
        System.out.println("No Fly");
    }
}
class JetFly implements IFly{
    @Override
    public void fly() {
        System.out.println("Jet Fly");
    }
}

interface IDisplay{
    void display();
}
class NormalDisplay implements IDisplay{
    @Override
    public void display() {
        System.out.println("Normal Duck");
    }
}
class NoDuckDisplay implements IDisplay{
    @Override
    public void display() {
        System.out.println("Fake Duck");
    }
}
class SpecialDisplay implements IDisplay{
    @Override
    public void display() {
        System.out.println("Special Duck");
    }
}

class Duck{
    IQuack quacking;
    IFly flying;
    IDisplay displaying;
    public Duck(IQuack quacking, IFly flying, IDisplay displaying){
        this.quacking = quacking;
        this.flying = flying;
        this.displaying = displaying;
    }
    public void quack(){
        quacking.quack();
    }
    public void fly(){
        flying.fly();
    }
    public void display(){
        displaying.display();
    }
}
