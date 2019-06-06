package example.client.controller;

import com.alibaba.fastjson.JSON;
import example.client.remote.TestRemote;
import example.client.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
public class TestController {

    @Resource
    private TestRemote testRemote;
    @Resource
    private AsyncService asyncService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String getCity(@RequestBody String param) {
        String test = testRemote.test(param);
        String returnString = "api param: " + test;
        System.out.println(returnString);
        return test;
    }

    @RequestMapping(value = "/asyncTest",method = RequestMethod.POST)
    public String asyncTest(@RequestBody String param) throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<>();

        log.info("asyncTest start");
        long start = System.currentTimeMillis();


        for (int i = 0; i < 5; i++) {
            list.add(testRemote.test(param+i));
        }
        log.info(JSON.toJSONString(list));

       /* List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(asyncService.asyncTest(param + i));
        }
        for (Future<String> future : futures) {
            list.add(future.get());
        }*/
        log.info(JSON.toJSONString(list));
        long end = System.currentTimeMillis();
        log.info("asyncTest end time elapsed:{}",(end-start));
        return JSON.toJSONString(list);

    }
}
