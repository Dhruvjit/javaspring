package springcodes;

import org.springframework.context.annotation.Lazy;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println ("cricket coach: inside no-arg constructor");
	}
	
	// get and set email address /////////////////
	
	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach setter: set email address");
		this.emailAddress = emailAddress;
	}

	
	// get and set team /////////////////////////////////

	public String getTeam() {
		System.out.println("CricketCoach setter: set team");
		return team;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	@Lazy
	// create setter method in your class for injections
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach setter: inside no-arg constructor");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bowling 15 mins/day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
