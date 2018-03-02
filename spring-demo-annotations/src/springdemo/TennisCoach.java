package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// when spring scans this package, its gonna find this class and 
// automatically will register this bean

//@Component("thatSillyCoach")
@Component 
public class TennisCoach implements Coach {
	
	// field injection using autowired (so easy approach of injection)
	@Autowired
	private FortuneService fortuneService;
	//
	
//	// constructor injection using autowired 
//	@Autowired
//	public TennisCoach (FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
//	///
	
	
//	// setter injection technique
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
//	///
	
	
//	// any method injection technique :P
//	@Autowired
//	public void shitYourPants(FortuneService fortuneService) {
//		
//		// we assigned a copy of instance to private field instance here
//		// by doing so we fortuneService to point null and also configure
//		// autowired correctly
//		
//		// look carefully, both the names are same below
//		this.fortuneService = fortuneService;
//	}
	
	
	@Override
	public String getDailyWorkput() {
		return "Practice batting workout daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
