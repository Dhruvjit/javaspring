package springcodes;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// empty constructor for myapp.java file so that it doesnt throw error
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "run like usain bolt";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach says " + fortuneService.getFortune();
	}

}
