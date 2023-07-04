package factory.method;

public class Consumer {
    public static void main( String[] args ){
        Car car = new BMWFactory().getCar();
        Car car1 = new TeslaFactory().getCar();
//      满足了开闭原则，但每多一个类，就需要多一个类工厂，中间类会越来越多
        car.name();
        car1.name();
    }
}
