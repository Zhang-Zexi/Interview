package interview.adv;

import interview.designpattern.task.CodingTask;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName ExecutorTester
 * @Description
 * @Author zhangzx
 * @Date 2019/4/26 11:09
 * Version 1.0
 **/
public class ExecutorTester {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //new ThreadPoolExecutor(0, 0, 0, null, null);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> taskResults = new LinkedList<>();
        for (int i = 0; i < 10; i ++) {
            taskResults.add(executor.submit(new CodingTask(i)));
        }

        System.out.println("10 tasks dispatched sucessfully");

        for (Future<?> taskResult : taskResults) {
            taskResult.get();
        }

        System.out.println("All tasks finished");
        executor.shutdown();
    }
}
