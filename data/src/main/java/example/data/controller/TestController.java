package example.data.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String getCity(@RequestBody String param) {
        String returnString = "clint param: " + param;
        System.out.println(returnString);
        return returnString;
    }
}
