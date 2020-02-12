package observables;

import rx.Observable;
import rx.Observer;

public class ObserverIntroduction {
    public static void run() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getLocalizedMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        };

        observable.subscribe(observer);
    }
}
