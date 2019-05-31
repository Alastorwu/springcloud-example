package example.client.remote;

import example.client.remote.impl.TestRemoteImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(value = "example-springcloud-data", fallback = TestRemoteImpl.class)
public interface TestRemote {

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	String test(@RequestParam("param") String param);
}
