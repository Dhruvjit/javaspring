package springSourceCode;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private FortuneService fortuneService;
	
	// bean injection using constructor method 
	public SwimCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	// bean injection using setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkput() {
		// TODO Auto-generated method stub
		return "swim 1000 meters as a warmup";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return team;
	}

}
