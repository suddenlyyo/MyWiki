package com.zx.multithreading;

import org.junit.jupiter.api.Test;



public class MultiThreadingTest {


    @Test
    public void threadTest() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void runnableTest() {
        MyRunnable myRunnable = new MyRunnable("Thread-1");
        myRunnable.start();
    }

    @Test
    public void anonymousThreadTest() {
        //匿名类
        Thread thread = new Thread() {
            @Override
            public void run() {
                int ticket = 10;
                for (int i = 0; i < 20; i++) {
                    if (ticket > 0) {
                        System.out.println(this.getName() + " 卖票：ticket" + ticket--);
                        try {
                            //当前线程暂停1000毫秒 ，其他线程不受影响
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            //当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        thread.start();
        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            thread.join();
        } catch (InterruptedException e) {
            //当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
            throw new RuntimeException(e);
        }
    }

    @Test
    public void joinThreadTest() {
        //在Java中，调用线程的join()方法的情况通常发生在以下几种情况：
        //
        //等待线程结束：join()方法用于等待线程结束。如果你创建了一个线程，并且你希望在主线程中等待这个新线程执行完毕后再继续执行，
        //那么你可以调用这个新线程的join()方法。这会阻塞主线程直到新线程执行完毕。
        //
        //收集线程结果：当新线程执行的任务对主线程有影响或者需要获取新线程执行的结果时，可以使用join()方法。通过join()方法获取到新线程执行的结果或者处理新线程的异常。
        //
        //请注意，如果一个线程是守护线程，那么它不能被中断，也不能调用join()方法。此外，如果主线程调用任何线程的join()方法，那么主线程必须等待这个线程完成。
        //如果主线程调用一个守护线程的join()方法，那么主线程将会被阻塞，直到守护线程执行完毕。这是因为join()方法的作用是等待另一个线程完成执行。
        //
        //然而，在Java中，守护线程（也称为服务线程）是一种特殊的线程，它不具有独立的执行上下文，通常用于执行后台任务或为其他线程提供支持。
        // 由于守护线程的这种性质，一旦主线程调用了守护线程的join()方法，它将一直等待，直到守护线程完成执行。
        //
        //需要注意的是，如果守护线程是守护线程组的成员，并且主线程调用了守护线程组的join()方法，那么主线程将会等待所有守护线程执行完毕才会继续执行。
        //
        //总之，主线程调用守护线程的join()方法将导致主线程被阻塞，直到守护线程执行完毕。
        //但是需要注意的是，这种行为并不常见，因为守护线程通常用于执行后台任务或提供支持，而不是与主线程进行交互
        MyThread myThread = new MyThread();
        myThread.start();
        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            myThread.join();
        } catch (InterruptedException e) {
            //当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setPriorityTest() {
        //当线程处于竞争关系的时候，优先级高的线程会有更大的几率获得CPU资源
        // 创建三个线程并设置不同的优先级
        Thread thread1 = getThread("Thread-1", Thread.MAX_PRIORITY);

        Thread thread2 = getThread("Thread-2", Thread.MIN_PRIORITY);

        Thread thread3 = getThread("Thread-3", Thread.NORM_PRIORITY);

        // 启动这三个线程,观察执行顺序差异
        thread2.start();
        thread3.start();
        thread1.start();
    }

    /**
     * 创建一个线程
     *
     * @param threadName 线程名称
     * @param priority   线程优先级
     * @return Thread
     * @author: zhou  xun
     * @since: 2023-10-25
     */
    private Thread getThread(String threadName, int priority) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " running, priority: " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(500); // 让线程暂停一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, threadName);
        thread.setPriority(priority); // 设置线程1优先级为最高
        return thread;
    }

    @Test
    public void yieldTest() {
        //创建了两个线程t1和t2，它们都执行一个循环，循环中打印一条消息并调用yield()方法。
        // 在理论上，这两个线程应该交替执行，但是由于操作系统的调度策略等因素，实际效果可能会有所不同。运行这个程序，你可能会看到不同的输出顺序。
        Thread t1 = getYieldThread("Thread 1");
        Thread t2 = getYieldThread("Thread 2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Thread getYieldThread(String threadName) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " running");
                //用于告诉操作系统当前线程愿意放弃剩余的时间片，让其他线程有机会运行
                Thread.yield();
            }
        }, threadName);
    }

    @Test
    public void daemonTest() {
        //在Java中，如果一个进程中的所有线程都是守护线程，并不会自动结束当前进程。
        // 守护线程（Daemon Thread）是在后台运行的线程，通常用于执行辅助任务，例如处理垃圾回收、监控系统资源等。
        //
        //守护线程与前台线程（User Thread）的主要区别在于，当只剩下守护线程时，Java虚拟机会自动退出。
        // 这意味着，如果一个进程中只剩下守护线程，并且没有其他活动进程或应用程序与该进程相关联，那么该进程会自动结束。
        //
        //但是，如果存在其他前台线程或其他进程与该进程相关联，即使所有守护线程都结束了，该进程也不会自动结束。在这种情况下，需要显式地终止当前进程或等待其他相关进程的结束。
        //
        //总之，当一个进程中的所有线程都是守护线程时，该进程会自动结束，但这仅适用于没有其他活动进程或应用程序与该进程相关联的情况。在其他情况下，需要显式地终止当前进程或等待其他相关进程的结束
        // 启动一个守护线程
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    // 在这里执行你的任务
                    System.out.println("守护程序线程正在运行...");
                    Thread.sleep(1000); // 等待一段时间，这里使用 sleep 来简化示例
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 在其他进程完成后，守护线程可以执行一些清理工作或退出
            System.out.println("守护程序线程正在退出...");
        });
        daemonThread.setDaemon(true); // 设置守护线程
        daemonThread.start(); // 启动守护线程

        // 主线程退出后，守护线程会继续运行
        System.out.println("主线程正在退出...");
    }

    /**
     * 内部类是一种特殊的类，它被定义在一个类的内部。使用内部类的好处包括更好的封装和隐藏实现细节。
     * <p>
     * 在Java中，内部类可以访问外部类的私有属性和方法，这有助于实现更灵活的设计和更好的封装。
     * <strong>内部类也可以定义在方法内部，称为局部内部类。</strong>
     * 局部内部类可以访问方法中的局部变量，并且可以在方法之外使用。
     * <strong>
     * 在某些情况下，我们需要将内部类声明为静态的。静态内部类的特点是没有外部类的实例，就可以创建静态内部类的实例，即不需要依赖外部类。
     * 静态内部类只能访问外部类的静态成员（变量和方法），不能访问外部类的非静态成员。
     * </strong>
     * 以下是一些使用静态内部类的场景：
     * <p>
     * 静态内部类可以作为工具类，用于封装某些工具方法，这些方法不依赖于外部类的实例。
     * 静态内部类可以用于实现回调接口，例如Comparator接口，以实现某些排序功能。
     * 静态内部类可以用于实现单例模式。通过将内部类声明为静态的，可以确保只有一个实例被创建，并且可以在没有外部类实例的情况下访问该实例。
     */
    static class MyThread extends Thread {
        private int ticket = 10;

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                if (this.ticket > 0) {
                    System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        private Thread thread;
        private String threadName;
        private int ticket = 10;

        MyRunnable(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
                }
            }
        }

        public void start() {
            if (thread == null) {
                thread = new Thread(this, threadName);
                thread.start();
            }
        }
    }
}
