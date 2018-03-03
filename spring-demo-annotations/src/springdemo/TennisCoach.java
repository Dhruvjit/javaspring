package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// when spring scans this package, its gonna find this class and 
// automatically will register this bean

//@Component("thatSillyCoach")
@Component 
// default scope is singleton
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	// field injection using autowired (so easy approach of injection)
	@Autowired
	@Qualifier("randomService") // First letter lower case (thats how it is)
	private FortuneService fortuneService;
	//
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside of doMyStartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside of doMyCleanupStuff");
	}
	
	
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
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
	
	@Override
	public String getDailyWorkput() {
		return "Practice batting workout daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
