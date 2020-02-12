package observables;

import rx.Observable;

public class EmptyAndNeverObservable {
    public static void run(){
        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println,System.out::println,()->System.out.println("Completed"));
    }

    private static void createObservableUsingNever() {
        Observable observable = Observable.never();
        observable.subscribe(System.out::println,System.out::println,()->System.out.println("Completed"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
