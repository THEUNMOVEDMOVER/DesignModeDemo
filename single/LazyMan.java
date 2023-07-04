package single;

public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + " Started");
    }

    private volatile static LazyMan lazyMan;

//    public static LazyMan getInstance(){
//        if( lazyMan == null )
//            lazyMan = new LazyMan();
//        return lazyMan;
//    }
    //双重检测的懒汉式单例，又称DCL懒汉式
    public static LazyMan getInstance(){
        if( lazyMan == null ){
            synchronized (LazyMan.class){
                if( lazyMan == null )
                    lazyMan = new LazyMan(); //不是原子性操作，仍然可能有问题
                /*
                1. 分配内存空间
                2. 执行构造方法，初始化对象
                3. 把对象指向空间

                指令重排，123变成132，在一个线程的时候没问题，但若此时再并发一个线程，则可能会有问题
                这个新并发的线程发现lazyMan不为空，则会跳过if，直接return，但此时return的是一个未完成构造的lazyMan
                为避免指令重排，一定要加上volatile关键字
                 */
            }
        }

        return lazyMan;
    }

    public static void main(String[] args){
        for( int i=0; i<10; i++ )
        {
            new Thread(
                    ()->{
                        LazyMan.getInstance();
                    }
            ).start();
        }
    }

}
