package observables;

import rx.Observable;

public class CallableToLazy {
    public static void run() {
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling Method");
            return getNumber();
        });
        observable.subscribe(System.out::println,error -> System.out.println("An exception Occurred "+error.getLocalizedMessage()));
    }

    private static int getNumber() {
        System.out.println("Generating value");
        return 1/0;
    }

}
