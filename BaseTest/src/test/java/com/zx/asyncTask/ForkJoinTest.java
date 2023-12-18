package com.zx.asyncTask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 任务拆分，并发处理
 */
public class ForkJoinTest {
    private static ForkJoinPool forkJoinPool;

    //invoke：提交任务并进行阻塞，直到任务完成返回合并结果
    //execute：异步执行任务，无返回值
    //submit：异步执行任务，返回task本身，可以通过task.get来获取结果
    @DisplayName("forkJoinPool invoke提交任务并进行阻塞，直到任务完成返回合并结果")
    @Test
    public void invoke() {
        forkJoinPool = new ForkJoinPool();
        long[] numbers = LongStream.rangeClosed(1, 100000000).toArray();
        Long result;
        try {
            result = forkJoinPool.invoke(new SumTask(numbers, 0, numbers.length - 1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        forkJoinPool.shutdown();
        System.out.println("最终结果：" + result);
        System.out.println("活跃线程数：" + forkJoinPool.getActiveThreadCount());
        System.out.println("窃取任务数：" + forkJoinPool.getStealCount());
    }

    //ForkJoinTask的join和get方法在功能和异常处理上存在显著的差异。
    //
    //功能：
    //
    //join方法：join方法主要用于等待任务完成并获取其结果。它阻塞调用线程直到任务完成，并返回任务的结果。换句话说，join方法用于在任务完成之前阻塞调用线程，并保证能够获取到任务执行的结果。
    //get方法：get方法也可以获取任务的结果，但它与join方法不同，它不会阻塞调用线程。如果任务尚未完成，get方法会立即返回null。
    //异常处理：
    //
    //join方法：如果任务抛出任何异常，join方法会直接抛出InterruptedException异常。也就是说，如果在等待任务完成的过程中线程被中断，join方法会抛出InterruptedException异常。
    //get方法：如果任务抛出任何未受检异常，get方法会返回一个ExecutionException异常。对于受检异常，get方法会将其封装成ExecutionException并返回。这意味着get方法不会直接抛出异常，而是通过返回异常对象来处理异常情况。
    //综上所述，ForkJoinTask的join和get方法在功能和异常处理上有所不同。join方法用于等待任务完成并获取其结果，而get方法则不会等待任务完成。同时，join方法在遇到异常时会直接抛出InterruptedException异常，而get方法则会将未受检异常封装成ExecutionException并返回。
    @DisplayName("forkJoinPool submit异步执行任务，返回task本身，可以通过task.get来获取结果")
    @Test
    public void submit() {
        forkJoinPool = new ForkJoinPool();
        // 提交可分解的PrintTask任务
        ForkJoinTask<Void> submit = forkJoinPool.submit(new myRecursiveAction(0, 1000000000));
        try {
            submit.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("并行度:" + forkJoinPool.getParallelism());
        // 关闭线程池
        forkJoinPool.shutdown();
    }

    /**
     * 求和任务类继承RecursiveTask
     * ForkJoinTask一共有3个实现：
     * RecursiveTask：有返回值
     * RecursiveAction：无返回值
     * CountedCompleter：无返回值任务，完成任务后可以触发回调
     */
    private static class SumTask extends RecursiveTask<Long> {
        private final long[] numbers;
        private final Integer start;
        private final Integer end;

        public SumTask(long[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        /**
         * ForkJoin执行任务的核心方法
         *
         * @return Long
         */
        @Override
        protected Long compute() {
            if (end - start < 10) { // 设置拆分的最细粒度，即阈值，如果满足条件就不再拆分，执行计算任务
                long total = 0;
                for (int i = start; i <= end; i++) {
                    total += numbers[i];
                }
                return total;
            } else { // 否则继续拆分，递归调用
                int middle = (start + end) / 2;
                SumTask taskLeft = new SumTask(numbers, start, middle);
                SumTask taskRight = new SumTask(numbers, middle + 1, end);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }
    }

    private static class myRecursiveAction extends RecursiveAction {
        private static final int MAX = 10;

        private final int start;
        private final int end;

        public myRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) < MAX) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + "i的值" + i);
                }
            } else {

                int middle = (start + end) / 2;
                myRecursiveAction taskLeft = new myRecursiveAction(start, middle);
                myRecursiveAction taskRight = new myRecursiveAction(middle, end);
                taskLeft.fork();
                taskRight.fork();
            }
        }
    }

}
