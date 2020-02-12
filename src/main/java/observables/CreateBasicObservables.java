package observables;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class CreateBasicObservables {
    public static void run(){
        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(emmiter -> {
            emmiter.onNext(1);
            emmiter.onNext(2);
            emmiter.onNext(3);
            emmiter.onNext(4);
            emmiter.onNext(5);
            emmiter.onNext(null);
            emmiter.onCompleted();
        });
        observable.subscribe(System.out::println,
                error-> System.out.println("There was error: "+error.getLocalizedMessage()),
                ()->System.out.println("Completed"));
    }

    private static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Observable<Integer> observable = Observable.from(list);
        observable.subscribe(System.out::println);
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(System.out::println);
    }
}
