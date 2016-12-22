package com.jsheng;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        main.doRxJavaTest();

        main.waitUserStop();
    }

    private void waitUserStop() {
        System.out.println("Press any key to stop it...");
        try {
            int _char = System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Stop it.");
        }
    }

    private void doRxJavaTest() {
        doRxSubjectTest();
    }

    private void doRxSubjectTest() {
//        RxSubject.testAsyncSubject();
//        RxSubject.testBehaviorSubject();
//        RxSubject.testPublishSubject();
//        RxSubject.testReplaySubject();
//        RxSubject.testSubjectAsObservable();
//        RxSubject.testSerializedSubject();
    }
}
