package singleton;

/**
 * 静态内部类
 */
public class SingletonTest2 {

    public SingletonTest2() {
    }

    private static class SingletonHolder {
        private static SingletonTest2 instance = new SingletonTest2();
    }

    public static SingletonTest2 getInstance() {
        return SingletonHolder.instance;
    }

}
