package AbstractFactory;

interface Chair{
    public void hasLegs();
    public void sitOn();
}
interface Sofa{
    public void sleep();
}
interface CoffeeTable{
    public void drink();
}
class ArtDecoChair implements Chair{

    @Override
    public void hasLegs() {
        System.out.println("Art Deco Chair legs");
    }

    @Override
    public void sitOn() {
        System.out.println("Sit on Art Deco Chair");
    }
}
class ArtDecoSofa implements Sofa{

    @Override
    public void sleep() {
        System.out.println("Sleep on Art Deco Sofa");
    }
}
class ArtDecoCoffeeTable implements CoffeeTable{

    @Override
    public void drink() {
        System.out.println("Drink on Art Deco Coffee Table");
    }
}

class VictorianChair implements Chair{

    @Override
    public void hasLegs() {
        System.out.println("Victorian Chair legs");
    }

    @Override
    public void sitOn() {
        System.out.println("Sit on Victorian Chair");
    }
}
class VictorianSofa implements Sofa{

    @Override
    public void sleep() {
        System.out.println("Sleep on Victorian Sofa");
    }
}
class VictorianCoffeeTable implements CoffeeTable{

    @Override
    public void drink() {
        System.out.println("Drink on Victorian Coffee Table");
    }
}

class ModernChair implements Chair{

    @Override
    public void hasLegs() {
        System.out.println("Modern Chair legs");
    }

    @Override
    public void sitOn() {
        System.out.println("Sit on Modern Chair");
    }
}
class ModernSofa implements Sofa{

    @Override
    public void sleep() {
        System.out.println("Sleep on Modern Sofa");
    }
}
class ModernCoffeeTable implements CoffeeTable{

    @Override
    public void drink() {
        System.out.println("Drink on Moder Coffee Table");
    }
}

interface IFactory{
    public Chair createChair();
    public Sofa createSofa();
    public CoffeeTable createCoffeeTable();
}

class VictorianFurnitureFactory implements IFactory{

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}
class ModernFurnitureFactory implements IFactory{

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

class ArtDecoFurnitureFactory implements IFactory{

    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
}

class AbstractFactory{
    String factory;
    public IFactory CreateFactory(String factory){
        if(factory.equalsIgnoreCase("Victorian"))
            return new VictorianFurnitureFactory();
        if(factory.equalsIgnoreCase("Modern"))
            return new ModernFurnitureFactory();
        if (factory.equalsIgnoreCase("art deco"))
            return new ArtDecoFurnitureFactory();
        return null;
    }

}
public class Main {

    public static void main(String[] args) {
	AbstractFactory abstractFactory = new AbstractFactory();
    IFactory iFactory = abstractFactory.CreateFactory("modern");
    Chair chair = iFactory.createChair();
    Sofa sofa = iFactory.createSofa();
    CoffeeTable coffeeTable =iFactory.createCoffeeTable();
    chair.hasLegs();
    chair.sitOn();
    sofa.sleep();
    coffeeTable.drink();
    }

}
