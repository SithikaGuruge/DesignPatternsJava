package Adapter;

interface Pen{
    public void draw();
}

class TempPen{
    public void mark(){
        System.out.println("Mark");
    }
}
class AdapterPen implements Pen{
    TempPen tempPen = new TempPen();
    @Override
    public void draw() {
        tempPen.mark();
    }
}



public class Adapter {
    public static void main(String[] args) {
        Pen pen1 = new AdapterPen();
        pen1.draw();
    }
}
