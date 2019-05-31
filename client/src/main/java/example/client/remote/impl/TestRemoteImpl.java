package example.client.remote.impl;

import example.client.remote.TestRemote;
import org.springframework.stereotype.Component;

@Component
public class TestRemoteImpl implements TestRemote {
    @Override
    public String test(String param) {
        System.out.println("fail param:"+param);
        return "fail";
    }
}
