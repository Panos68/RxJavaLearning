package observables;


import rx.Observable;
import rx.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class ObservableInterval {
    public static void run() {
        ConnectableObservable<Long> hotObservable = Observable.interval(1, TimeUnit.SECONDS).publish();

        hotObservable.subscribe(item -> System.out.println("Observer 1: " + item));
        pause(2000);
        hotObservable.connect();
        hotObservable.subscribe(item -> System.out.println("Observer 2: " + item));
        pause(3000);

        Observable<Long> coldObservable = Observable.interval(1, TimeUnit.SECONDS);

        coldObservable.subscribe(item -> System.out.println("Observer 3: " + item));
        pause(2000);
        coldObservable.subscribe(item -> System.out.println("Observer 4: " + item));
        pause(3000);
    }

    private static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
