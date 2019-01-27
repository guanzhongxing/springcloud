package singleton;

/**
 * 懒汉式单例,在第一次调用的时候就实例化
 */
public class SingletonTest1 {

    private static SingletonTest1 singletonTest1;

    public SingletonTest1() {
    }

//    public static SingletonTest1 getInstance() {
//        singletonTest1 = new SingletonTest1();
//        return singletonTest1;
//    }

    //线程安全 synchronized 锁的不是代码，是对象
    //双重检查加锁
    public static synchronized SingletonTest1 getInstance() {
        if (null == singletonTest1) {
            synchronized (SingletonTest1.class) {
                if (null == singletonTest1) {
                    singletonTest1 = new SingletonTest1();
                }
            }
        }
        return singletonTest1;
    }

}
