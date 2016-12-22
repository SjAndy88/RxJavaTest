package com.jsheng.subject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjun on 2016/12/22.
 *
 * https://mcxiaoke.gitbooks.io/rxdocs/content/Subject.html
 */
public class RxSubject {

    /**
     * 一个AsyncSubject只在原始Observable完成后，发射来自原始Observable的最后一个值。（如果原始Observable没有发射任何值，
     * AsyncObject也不发射任何值）它会把这最后一个值发射给任何后续的观察者。
     *
     * 然而，如果原始的Observable因为发生了错误而终止，AsyncSubject将不会发射任何数据，只是简单的向前传递这个错误通知。
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.AsyncSubject.png
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.AsyncSubject.e.png
     */
    public static void testAsyncSubject() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();

        // 发射前订阅，在原始Observable完成后，发射最后一个值
        asyncSubject.subscribe(v -> System.out.println("before, " + v));

        asyncSubject.onNext("Hello");

        asyncSubject.onNext("Fuck");

        // 发射后订阅，依然发射最后一个值
        asyncSubject.subscribe(v -> System.out.println("after,  " + v));

        asyncSubject.onNext("World");

        // 不调用onCompleted()方法，就不会有任何输出
        asyncSubject.onCompleted();

        // 发射完成后，依然发射最后一个值
        asyncSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete, onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("complete, onError:" + e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("complete, onNext:" + s);
            }
        });
    }

    /**
     * 当观察者订阅BehaviorSubject时，它开始发射原始Observable最近发射的数据（如果此时还没有收到任何数据，
     * 它会发射一个默认值），然后继续发射其它任何来自原始Observable的数据。
     *
     * 然而，如果原始的Observable因为发生了一个错误而终止，BehaviorSubject将不会发射任何数据，只是简单的向前传递这个错误通知。
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.BehaviorSubject.png
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.BehaviorSubject.e.png
     */
    public static void testBehaviorSubject() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("Default");

        // 订阅前无数据，则先发射默认值
        behaviorSubject.subscribe(v -> System.out.println("before, " + v));

        behaviorSubject.onNext("Hello");
        behaviorSubject.onNext("Fuck");

        // 订阅前有数据，则不发射默认值，但不从头发射，只将订阅前的一个发射
        behaviorSubject.subscribe(v -> System.out.println("after,  " + v));

        behaviorSubject.onNext("World");

        behaviorSubject.onCompleted();

        // 发射完后，再订阅，直接收到完成事件
        behaviorSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete, onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("complete, onError:" + e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("complete, onNext:" + s);
            }
        });
    }

    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者。
     * 需要注意的是，PublishSubject可能会一创建完成就立刻开始发射数据（除非你可以阻止它发生），
     * 因此这里有一个风险：在Subject被创建后到有观察者订阅它之前这个时间段内，一个或多个数据可能会丢失。
     * 如果要确保来自原始Observable的所有数据都被分发，你需要这样做：或者使用Create创建那个Observable
     * 以便手动给它引入"冷"Observable的行为（当所有观察者都已经订阅时才开始发射数据），或者改用ReplaySubject。
     *
     * 如果原始的Observable因为发生了一个错误而终止，PublishSubject将不会发射任何数据，只是简单的向前传递这个错误通知。
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.PublishSubject.png
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.PublishSubject.e.png
     */
    public static void testPublishSubject() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        // 发射前订阅，所有的发射数据都不丢失
        publishSubject.subscribe(v -> System.out.println("before, " + v));

        publishSubject.onNext("Hello");
        publishSubject.onNext("Fuck");

        // 发射后订阅，订阅前的发射数据都丢失
        publishSubject.subscribe(v -> System.out.println("after,  " + v));

        publishSubject.onNext("World");

        publishSubject.onCompleted();

        // 发射完后，再订阅，直接收到完成事件
        publishSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete, onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("complete, onError:" + e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("complete, onNext:" + s);
            }
        });
    }

    /**
     * ReplaySubject会发射所有来自原始Observable的数据给观察者，无论它们是何时订阅的。
     * 也有其它版本的ReplaySubject，在重放缓存增长到一定大小的时候或过了一段时间后会丢弃旧的数据（原始Observable发射的）。
     *
     * 如果你把ReplaySubject当作一个观察者使用，注意不要从多个线程中调用它的onNext方法（包括其它的on系列方法），
     * 这可能导致同时（非顺序）调用，这会违反Observable协议，给Subject的结果增加了不确定性。
     *
     * https://mcxiaoke.gitbooks.io/rxdocs/content/images/S.ReplaySubject.png
     */
    public static void testReplaySubject() {
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        // 发射前订阅，所有的发射数据都不丢失
        replaySubject.subscribe(v -> System.out.println("before, " + v));

        replaySubject.onNext("Hello");
        replaySubject.onNext("Fuck");

        // 发射后订阅，收到之前所有发射数据
        replaySubject.subscribe(v -> System.out.println("after,  " + v));

        replaySubject.onNext("World");

        replaySubject.onCompleted();

        // 发射完后，再订阅，收到之前所有发射数据
        replaySubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete, onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("complete, onError:" + e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("complete, onNext:" + s);
            }
        });
    }

    /**
     * 假设你有一个Subject，你想把它传递给其它的代理或者暴露它的Subscriber接口，
     * 你可以调用它的asObservable方法，这个方法返回一个Observable。具体使用方法可以参考Javadoc文档。
     */
    public static void testSubjectAsObservable() {
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        Observable<String> asObservable = replaySubject.asObservable();
    }

    /**
     * 如果你把 Subject 当作一个 Subscriber 使用，注意不要从多个线程中调用它的onNext方法（包括其它的on系列方法），
     * 这可能导致同时（非顺序）调用，这会违反Observable协议，给Subject的结果增加了不确定性。
     *
     * 要避免此类问题，你可以将 Subject 转换为一个 SerializedSubject ，类似于这样：
     *  mySafeSubject = new SerializedSubject( myUnsafeSubject );
     */
    public static void testSerializedSubject() {
        PublishSubject<String> publishSubject = PublishSubject.create();

        SerializedSubject<String, String> serializedSubject = new SerializedSubject<>(publishSubject);
    }
}
