package springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "today is a fucking sad day, but 0 fucks given";
	}
	
}
