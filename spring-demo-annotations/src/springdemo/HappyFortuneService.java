package springdemo;

import org.springframework.stereotype.Component;

// this component enables spring to register it when it scans all the package
@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "today is your lucky day";
	}

}
