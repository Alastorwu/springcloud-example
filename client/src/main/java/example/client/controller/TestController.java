package example.client.controller;

import example.client.remote.TestRemote;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestRemote testRemote;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String getCity(@RequestBody String param) {
        String returnString = "clint param: " + testRemote.test(param);
        System.out.println(returnString);
        return returnString;
    }
}
