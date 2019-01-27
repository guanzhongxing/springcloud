package singleton;

/**
 * 饿汉式单例
 */
public class SingletonTest3 {

    private static SingletonTest3 instance = new SingletonTest3();

    public SingletonTest3() {
    }

    private static class SingletonHolder {
        private static SingletonTest3 instance = new SingletonTest3();
    }

    public static SingletonTest3 getInstance() {
        return instance;
    }

}
