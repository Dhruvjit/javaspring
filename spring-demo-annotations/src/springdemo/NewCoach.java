package springdemo;

import org.springframework.stereotype.Component;

@Component("newCoachComponent")
public class NewCoach implements Coach {

	@Override
	public String getDailyWorkput() {
		
		return "I am the new coach. bitch!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
