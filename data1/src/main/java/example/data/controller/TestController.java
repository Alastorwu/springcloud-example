package example.data.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String getCity(@RequestParam("param") String param) throws InterruptedException {
        String returnString = "data1 param: " + param;
        //Thread.sleep(1000);
        System.out.println(returnString);
        return returnString;
    }
}
