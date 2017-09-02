package springcodes;


public class BaseballCoach implements Coach {
	
	// define a private field for the dependency
	// fortuneservice is dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection i.e. how to implement injection
	public BaseballCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
 
	@Override
	public String getDailyWorkout() {
		return "30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
	

}
