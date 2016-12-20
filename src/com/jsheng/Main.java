package com.jsheng;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
//	// write your code here

//        List input = Arrays.asList("apple", "orange", "pear");
//        input.forEach(System.out::println);
//        input.forEach((v) -> System.out.println(v));
//
//        List dateValues = Arrays.asList(0L, 1000L);
////        List dates = CollectionUtils.transform(dateValues, (Long v) -> new Date(v));
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        list.stream().filter((x) -> x % 2 == 0).map((x) -> x*x).forEach(System.out::println);
//        int sum = list.stream().filter((x) -> x % 2 == 0).map((x) -> x*x).reduce((x, y) -> x + y).get();
//        System.out.println("args = [" + sum + "]");


//        Observable.just("Hello", "Big", "World")
//                .filter(str -> str.endsWith("Good"))
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.just("Hello", "Big", "World")
//                .repeat(3)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Main main =  new Main();
//        Observable<Integer> deferred = Observable.defer(main::getInt);
//        deferred.subscribe(number -> System.out.println("args = [" + number + "]"));


//        Observable.range(10, 3)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext : " + integer);
//                    }
//                });


//        Subscription stopMePlease = Observable.interval(3, TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println("onNext : " + aLong);
//                    }
//                });


//        Subscription stopMePlease = Observable.interval(1, 3, TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println("onNext : " + aLong);
//                    }
//                });


//        Subscription stopMePlease = Observable.timer(3, TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("Thread : " + Thread.currentThread().getName());
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("Thread : " + Thread.currentThread().getName());
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println("Thread : " + Thread.currentThread().getName());
//                        System.out.println("onNext : " + aLong);
//                    }
//                });

//
//        Observable.just("Hello", "Big", "World")
//                .take(3)
//                .repeat(3)
//                .distinct()
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.just("Hello", "Big", "World", "Hellx", "Good", "World")
//                .distinct()
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.just(1, 1, 2, 1, 2, 3, 2, 2, 3, 4)
//                .distinctUntilChanged()
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer i) {
//                        System.out.println("onNext : " + i);
//                    }
//                });


//        Observable.just("Hello", "World", "Big", "Fuck", "Bottom", "Sample", "Good")
//                .last(s -> s.startsWith("B"))
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.just("Hello", "World", "Big", "Fuck", "Bottom", "Sample", "Good")
//                .lastOrDefault("HaHa", s -> s.startsWith("P"))
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.just("Hello", "World", "Big", "Fuck", "Bottom", "Sample", "Good")
//                .elementAt(2)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });

//            Observable.just("Hello", "World", "Big", "Fuck", "Bottom", "Sample", "Good")
//                .elementAtOrDefault(10, "HaHa")
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });


//        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
//            for (int i = 0; i < 10; i++) {
//                if (subscriber.isUnsubscribed()) {
//                    return;
//                }
//                subscriber.onNext(i);
//                int sleepTime = (int) (Math.round(Math.random() * 3) * 1000);
//                System.out.println("sleepTime = [" + sleepTime + "]");
//                try {
//                    Thread.sleep(sleepTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (!subscriber.isUnsubscribed()) {
//                subscriber.onCompleted();
//            }
//
//        })
//                .sample(3, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext : " + integer);
//                    }
//                });


//        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
//            for (int i = 0; i < 10; i++) {
//                if (subscriber.isUnsubscribed()) {
//                    return;
//                }
//                subscriber.onNext(i);
//                int sleepTime = (int) (Math.round(Math.random() * 3) * 1000);
//                System.out.println("sleepTime = [" + sleepTime + "]");
//                try {
//                    Thread.sleep(sleepTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (!subscriber.isUnsubscribed()) {
//                subscriber.onCompleted();
//            }
//
//        })
//                .throttleFirst(3, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext : " + integer);
//                    }
//                });


//        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    if (subscriber.isUnsubscribed()) {
//                        return;
//                    }
//                    subscriber.onNext(i);
//                    int sleepTime = (int) (Math.round(Math.random() * 6) * 1000);
//                    System.out.println("sleepTime = [" + sleepTime + "]");
//                    Thread.sleep(sleepTime);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (!subscriber.isUnsubscribed()) {
//                subscriber.onCompleted();
//            }
//
//        })
//                .timeout(4, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext : " + integer);
//                    }
//                });


//        Observable.create((Observable.OnSubscribe<Integer>) subscriber -> {
//            try {
//                for (int i = 0; i < 10; i++) {
//                    if (subscriber.isUnsubscribed()) {
//                        return;
//                    }
//                    subscriber.onNext(i);
//                    int sleepTime = (int) (Math.round(Math.random() * 5) * 100);
//                    System.out.println("sleepTime = [" + sleepTime + "]");
//                    Thread.sleep(sleepTime);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (!subscriber.isUnsubscribed()) {
//                subscriber.onCompleted();
//            }
//
//        })
//                .debounce(300, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext : " + integer);
//                    }
//                });

//        Observable<String> just1 = Observable.just("Hello 11", "Hello 12", "Hello 13", "Hello 14", "Hello 15", "Hello 16", "Hello 17");
//        Observable<String> just2 = Observable.just("Hello 27", "Hello 26", "Hello 25", "Hello 24", "Hello 23", "Hello 22", "Hello 21");
//        Observable.merge(just1, just2)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError : " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext : " + s);
//                    }
//                });

//        List<String> just1 = Arrays.asList("Hello 11", "Hello 12", "Hello 13", "Hello 14", "Hello 15", "Hello 16", "Hello 17");
//        List<String> just2 = Arrays.asList("Hello 27", "Hello 26", "Hello 25", "Hello 24", "Hello 23", "Hello 22", "Hello 21");
//        Observable<String> tObservable1 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just1.size(); i++) {
//                    System.out.println("Thread : " + Thread.currentThread().getName());
//                    subscriber.onNext(just1.get(i));
//                    Thread.sleep(i * 100);
//                }
//                subscriber.onCompleted();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable<String> tObservable2 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just2.size(); i++) {
//                    System.out.println("Thread : " + Thread.currentThread().getName());
//                    subscriber.onNext(just2.get(i));
//                    Thread.sleep(i * 100);
//                }
//                subscriber.onCompleted();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable.merge(tObservable2, tObservable1)
//            .observeOn(Schedulers.newThread())
//            .subscribe(new Observer<String>() {
//                @Override
//                public void onCompleted() {
//                    System.out.println("onCompleted");
//                    System.out.println("onCompleted Thread : " + Thread.currentThread().getName());
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    System.out.println("onError : " + e.getMessage());
//                    System.out.println("onError Thread : " + Thread.currentThread().getName());
//                }
//
//                @Override
//                public void onNext(String s) {
//                    System.out.println("onNext : " + s);
//                    System.out.println("onNext Thread : " + Thread.currentThread().getName());
//                }
//            });

//        List<String> just1 = Arrays.asList("Hello 11", "Hello 12", null, "Hello 14", "Hello 15", "Hello 16", "Hello 17");
//        List<String> just2 = Arrays.asList("Hello 27", "Hello 26", "Hello 25", "Hello 24", "Hello 23", "Hello 22", "Hello 21");
//        Observable<String> tObservable1 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just1.size(); i++) {
//                    subscriber.onNext(just2.get(i).toUpperCase());
//                    Thread.sleep(i * 100);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable<String> tObservable2 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just1.size(); i++) {
//                    subscriber.onNext(just1.get(i).toUpperCase());
//                    Thread.sleep(i * 100);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable.mergeDelayError(tObservable1, tObservable2)
//            .subscribe(new Observer<String>() {
//                @Override
//                public void onCompleted() {
//                    System.out.println("onCompleted");
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    System.out.println("onError : " + e.getMessage());
//                }
//
//                @Override
//                public void onNext(String s) {
//                    System.out.println("onNext : " + s);
//                }
//            });

//        List<String> just1 = Arrays.asList("Hello 11", "Hello 12", "Hello 13", "Hello 14", "Hello 15", "Hello 16", "Hello 17");
//        List<String> just2 = Arrays.asList("Hello 27", "Hello 26", "Hello 25", "Hello 24", "Hello 23", "Hello 22", "Hello 21");
//        Observable<String> tObservable1 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just1.size(); i++) {
//                    System.out.println("Thread : " + Thread.currentThread().getName());
//                    subscriber.onNext(just1.get(i));
//                    Thread.sleep(i * 100);
//                }
//                subscriber.onCompleted();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable<String> tObservable2 = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
//            try {
//                for (int i = 0; i < just2.size(); i++) {
//                    System.out.println("Thread : " + Thread.currentThread().getName());
//                    subscriber.onNext(just2.get(i));
//                    Thread.sleep(i * 100);
//                }
//                subscriber.onCompleted();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable.merge(tObservable2, tObservable1)
//            .observeOn(Schedulers.newThread())
//            .subscribe(new Observer<String>() {
//                @Override
//                public void onCompleted() {
//                    System.out.println("onCompleted");
//                    System.out.println("onCompleted Thread : " + Thread.currentThread().getName());
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    System.out.println("onError : " + e.getMessage());
//                    System.out.println("onError Thread : " + Thread.currentThread().getName());
//                }
//
//                @Override
//                public void onNext(String s) {
//                    System.out.println("onNext : " + s);
//                    System.out.println("onNext Thread : " + Thread.currentThread().getName());
//                }
//            });


        for (; ; ) {

        }
    }

    private Observable<Integer> getInt() {
        return Observable.create(subscriber -> {
            if (subscriber.isUnsubscribed()) {
                return;
            }

            System.out.println("GETINT");
            subscriber.onNext(42);
            subscriber.onCompleted();
        });
    }
}
