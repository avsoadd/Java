package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController{
	Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@GetMapping("sample")
	public String get() {
		logger.info("access Get Sample");
		return null;
	}
}
