package hello.core.singleton;

public class SingletonService {
    private static final SingletonService singleton = new SingletonService();
    public static SingletonService getInstance(){
        return singleton;
    }
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 로직 호출");
    }
}
