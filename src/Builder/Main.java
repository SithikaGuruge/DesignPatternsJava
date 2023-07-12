package Builder;

class House {
    String garage;
    String swimmingPool;
    String fancyStatue;
    String garden;

    public House(String garage, String swimmingPool, String fancyStatue, String garden) {
        this.garage = garage;
        this.swimmingPool = swimmingPool;
        this.fancyStatue = fancyStatue;
        this.garden = garden;
    }

    @Override
    public String toString() {
        return "House{" +
                "garage='" + garage + '\'' +
                ", swimmingPool='" + swimmingPool + '\'' +
                ", fancyStatue='" + fancyStatue + '\'' +
                ", garden='" + garden + '\'' +
                '}';
    }
}
class Builder{
    String garage;
    String swimmingPool;
    String fancyStatue;
    String garden;
    public Builder setGarage(String garage) {
        this.garage = garage;
        return this;
    }

    public Builder setSwimmingPool(String swimmingPool) {
        this.swimmingPool = swimmingPool;
        return this;
    }

    public Builder setFancyStatue(String fancyStatue) {
        this.fancyStatue = fancyStatue;
        return this;
    }

    public Builder setGarden(String garden) {
        this.garden = garden;
        return this;
    }
    public House build(){
        return new House(garage,swimmingPool,fancyStatue,garden);
    }
}

public class Main {

    public static void main(String[] args) {
        House house = new Builder().setFancyStatue("Francy").setGarage("Garage").setGarden("Garden").build();
        System.out.println(house);

    }
}