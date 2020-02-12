import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class FirstGenericTutorial {
    public static void run() {
        Observable<String> createObserver = Observable.create(subscriber -> {
            subscriber.onNext("Hello World");
            subscriber.onCompleted();
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("MySubscriber onNext(): " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Subscriber completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("OnError");
            }
        };

        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("MyObserver onNext(): " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Observer completed");
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Observable<Integer> fromObservable = Observable.from(numbers);

        Subscriber<Integer> intSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }
        };


        Subscriber<Integer> intJustSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }
        };

        Observable<Integer> rangeObservable = Observable.range(2, 5);
        rangeObservable.subscribe(intSubscriber);

        Observable<Integer> justObservable = Observable.just(4, 4, 6, null);
        justObservable.subscribe(intJustSubscriber);
        fromObservable.subscribe(intSubscriber);
        createObserver.subscribe(mySubscriber);
        createObserver.subscribe(myObserver);
    }

}
