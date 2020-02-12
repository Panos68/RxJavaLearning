package Observer;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class Operators {
    public static void run() {
        takeAndRepeatOperator();
        takeWithInterval();
        takeWhile();
        skip();
        skipWhile();
        distinct();
        distinctWithKeySelector();
        distinctUntilChanged();
        scanWithInitialValue();
        sortOnNonComparator();
    }

    private static void sortOnNonComparator() {
        Observable.just("foo412","john","bar")
                .toSortedList((first,second)->Integer.compare(first.length(),second.length()))
                .subscribe(System.out::println);
    }

    private static void scanWithInitialValue() {
        Observable.just(1,2,3,4,5)
                .scan(10, Integer::sum)
                .subscribe(System.out::println);
    }

    private static void distinctUntilChanged() {
        Observable.just(1, 1, 2, 3, 5, 5, 1, 2, 3, 5).distinctUntilChanged().subscribe(System.out::println);

    }

    private static void distinctWithKeySelector() {
        Observable.just("test", "abcd", "asggas", "gpas")
                .distinct(item -> item.length()).subscribe(System.out::println);

    }

    private static void distinct() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 5, 6).distinct().subscribe(System.out::println);
    }

    private static void skipWhile() {
        Observable.just(1, 2, 3, 4, 5)
                .skipWhile(item -> item <= 3).subscribe(System.out::println);

    }

    private static void skip() {
        Observable.just(1, 2, 3, 4, 5).skip(2).subscribe(System.out::println);

    }

    private static void takeWhile() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 5, 6).takeWhile(item -> item <= 3).subscribe(System.out::println);

    }

    private static void takeWithInterval() {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println);

    }

    private static void takeAndRepeatOperator() {
        Observable.just(1, 2, 3, 4, 5).take(2).repeat(2).subscribe(System.out::println);
    }

}
