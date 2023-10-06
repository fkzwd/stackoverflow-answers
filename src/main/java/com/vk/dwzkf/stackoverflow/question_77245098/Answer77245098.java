package com.vk.dwzkf.stackoverflow.question_77245098;

import java.io.IOException;

/**
 * @author Roman Shageev
 * @since 06.10.2023
 */
public class Answer77245098 {
    interface MyInterface<T extends Exception> extends MyInterface2<T, T> {
        void run() throws T;
    }

    interface MyInterface2<T extends Exception, R extends Exception> extends MyInterface3<T, R, R> {
        void run() throws T, R;
    }

    interface MyInterface3<T extends Exception, R extends Exception, V extends Exception> extends MyInterface4<T, R, V, V> {
        void run() throws T, R, V;
    }

    interface MyInterface4<T extends Exception, R extends Exception, V extends Exception, Z extends Exception> {
        void run() throws T, R, V, Z;
    }

    interface MySuperInterface extends MyInterface<Exception> {
        void run();
    }

    public static void main(String[] args) throws Exception {
        mainMethod();
    }

    public static void mainMethod() throws IOException, IllegalAccessException {
        MyInterface<IOException> io = () -> {
            System.out.println("IO");
        };
        MyInterface<IllegalAccessException> iae = () -> {
            System.out.println("Illegal");
        };
        MyInterface2<IOException, IllegalAccessException> io_and_illegal = () -> {
            System.out.println("IO and Illegal");
        };

        MySuperInterface noException = () -> {
        };
        //can assign to runnable cause noException.run() doesnt throw an exception
        Runnable runnable = noException::run;

        consume(io);
        consume(iae);
        consume(noException);
        consume(io_and_illegal);
    }

    public static <T extends Exception, R extends Exception, V extends Exception, Z extends Exception> void consume(MyInterface4<T, R, V, Z> action) throws T, R, V, Z {
        action.run();
    }

    public static void consume(MySuperInterface action) {
        action.run();
    }
}
