package observables;

import rx.Observable;

public class ReactiveLoop {

    private static int start = 5, count = 2;

    public static void run() {
        Observable<Integer> observable = Observable.defer(() -> {
                    System.out.println("New Observable is created with start = " + start + " and count = " + count);
                    return Observable.range(start, count);
                }
        );
        observable.subscribe(item -> System.out.println("observer 1: " + item));

        count = 3;
        observable.subscribe(item -> System.out.println("observer 2: " + item));
    }
}
