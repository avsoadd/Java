package testdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestAPI {
	@PostMapping("/receive")
	public String receive(@RequestBody String json) {
		System.out.println("Test:" + json);
		return "";
	}
}
