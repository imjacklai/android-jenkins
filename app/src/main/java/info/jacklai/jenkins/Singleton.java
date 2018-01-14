package info.jacklai.jenkins;

/**
 * Created by jacklai on 2018/1/14.
 */

public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
