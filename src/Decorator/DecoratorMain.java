package Decorator;

interface DataSource{       //Create interface because there can be created FileDataSource or imageData Source
    public String writeData();
    public String readData();
}
class FileDataSource implements DataSource{

    @Override
    public String writeData() {
        return "Writing FileDataSource";
    }

    @Override
    public String readData() {
        return "Reading FileDataSource";
    }
}
class ImageDataSource implements DataSource{

    @Override
    public String writeData() {
        return "Writing ImageDataSource";
    }

    @Override
    public String readData() {
        return "Reading ImageDataSource";
    }
}
abstract class DataSourceDecorator implements DataSource{       //This must implements DataSource Interface
    DataSource dataSource;
    public DataSourceDecorator(DataSource dataSource){      //Specify the type of DataSource
        this.dataSource = dataSource;
    }
    public abstract String writeData();
    public abstract String readData();

}
class EncryptionDecorator extends DataSourceDecorator{      //Types of decorators

    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String writeData() {
       return "Add encryption Write Decoration " + dataSource.writeData(); //return decorator with concrete massage
    }

    @Override
    public String readData() {
        return "Add encryption Read Decoration " + dataSource.readData();
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        DataSource dataSource = new EncryptionDecorator(new FileDataSource());
        System.out.println(dataSource.writeData());

        DataSource dataSource1 = new EncryptionDecorator(new ImageDataSource());
        System.out.println(dataSource1.readData());
    }
}
