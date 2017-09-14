package springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class SwimCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}
	
	
	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;
	
	String getEmail(){
		return email;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as warm up";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}
}
