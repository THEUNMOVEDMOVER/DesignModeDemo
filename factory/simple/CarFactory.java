package factory.simple;

public class CarFactory {
    public static Car getCar(String car){
        if( car.equals("BMW") )
            return new BMW();
        else if ( car.equals("Tesla")) {
            return new Tesla();
        }
        else
            return null;
    }
    //这样若新增一个车类，代码逻辑就需要修改，违背了开闭原则
    //故简单工厂模式又称为静态工厂模式

    public static Car getBMW(){
        return new BMW();
    }

    public static Car getTesla(){
        return new Tesla();
    }
}
