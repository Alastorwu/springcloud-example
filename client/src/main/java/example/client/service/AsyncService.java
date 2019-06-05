package example.client.service;

import example.client.remote.TestRemote;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@Service
public class AsyncService {


    @Resource
    private TestRemote testRemote;


    @Async
    public Future<String> asyncTest(String param){
        return new AsyncResult<>(testRemote.test(param));
    }

    @Async
    public Future<String> doTask1() throws InterruptedException{
        System.out.println("Task1 started.");
        long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        System.out.println("Task1 finished, time elapsed: {"+(end-start)+"} ms.");

        return new AsyncResult<>("Task1 accomplished!");
    }

    @Async
    public Future<String> doTask2() throws InterruptedException{
        System.out.println("Task2 started.");
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();

        System.out.println("Task2 finished, time elapsed: {"+(end-start)+"} ms.");

        return new AsyncResult<>("Task2 accomplished!");
    }


}
