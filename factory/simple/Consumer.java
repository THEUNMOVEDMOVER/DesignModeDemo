package factory.simple;

public class Consumer {
    public static void main(String[] args){
//        Car car = new BMW();
//        Car car2 = new Tesla();

        Car car = CarFactory.getCar("BMW");
        Car car2 = CarFactory.getCar("Teala");

        //如果new的时候需要传参数，这种方法就可以节省很多功夫，所有的细节都不需要了解

        car.name();
        car2.name();
    }
}
