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



}
