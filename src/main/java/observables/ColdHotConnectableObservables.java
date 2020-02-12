package observables;

import rx.Observable;
import rx.observables.ConnectableObservable;

public class ColdHotConnectableObservables {

    public static void run() {
        createColdObservable();
        createHotAndConnectableObservable();
    }

    private static void createHotAndConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
        observable.connect();
        observable.subscribe(item -> System.out.println("Observer 3: " + item));

    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }
}
