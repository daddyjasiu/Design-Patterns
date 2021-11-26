interface Bike {
    void draw();
}

class MTB implements Bike {

    @Override
    public void draw() {
        System.out.println("Bike: MTB (Mountain Bike)");
    }
}

class BMX implements Bike {

    @Override
    public void draw() {
        System.out.println("Bike: BMX");
    }
}

abstract class BikeDecorator implements Bike {
    protected Bike decoratedBike;

    public BikeDecorator(Bike decoratedBike){
        this.decoratedBike = decoratedBike;
    }

    public void draw(){
        decoratedBike.draw();
    }
}

class GoldBikeDecorator extends BikeDecorator {

    public GoldBikeDecorator(Bike decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedBike.draw();
        setGoldBikeColor(decoratedBike);
    }

    private void setGoldBikeColor(Bike decoratedShape){
        System.out.println("Bike Color: Gold");
    }
}

public class Zadanie1 {

    public static void main(String[] args){
        Bike normalMTB = new MTB();
        Bike normalBMX = new BMX();

        Bike goldMTB = new GoldBikeDecorator(new MTB());
        Bike goldBMX = new GoldBikeDecorator(new BMX());

        normalMTB.draw();
        System.out.println();
        normalBMX.draw();
        System.out.println();
        goldMTB.draw();
        System.out.println();
        goldBMX.draw();
    }
}
