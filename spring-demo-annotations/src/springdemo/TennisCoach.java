package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// this annotation will make spring to make bean for us
// automatically with id = thatSillyCoach
// no two component names of two different class can be same

//if no bean id annotations are given with any name, you can still retrieve it by writing name of class
// starting with first small letter of the actual java class i.e. TennisCoach can also be retrieved by using
// Coach theCoach = context.getBean("tennisCoach", Coach.class);
// but first you need to remove that explicit declaration of bean for spring to make use of default bean id

// this component makes TennisCoach available to AnnotationDemoapp.java
@Component // or @Component("thatSillyCoach")
@Scope("singleton") // @Scope("prototype") will make new objects which are stored in different memory locations
public class TennisCoach implements Coach {
	
	/*
	 * field injection and qualifier example
	 * */
	
	/*you make field injection by putting autowire directly on the field like mentioned below
	 * spring will make use of java service called reflection
	 * and inject all the methods of this object for you
	 * so here we dont need setter or constructor injection anymore*/
	
	/*
	 * we use qualifier to specify which fortune service are we interested in
	 * this is useful when we have many classes implementing same interface
	 * and we need to specify which one to use*/
	
	// this is not type of injection but to specify which class to use
	////
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	
	// define a default constructor
	// we dont require this, but chad wrote this just so that we can track our program
	public TennisCoach(){
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	/*
	 * constructor injection example
	 * */
	
	/*constructor injection
	// we configured dependency injection by using autowired here
	// here you would do FortuneService theFortuneService = new FortuneService(), but not anymore in spring
	// spring does everything for you. So in below code spring will inject the instance for you
	// it is not compulsory for just one constructor starting spring 4.3 */
	
//	//@Autowired commented to show how setter injection works
//	
//	// create constructor for injection 
//	public TennisCoach(FortuneService theFortuneService){
//		fortuneService = theFortuneService;
//	}
	

	/*
	 * setter injection example
	 * */
	
//	//define a setter method
//	@Autowired
//	@Qualifier("randomFortuneService") // use this when there are multiple classes initiallizing same interface
//	public void setFortuneService(FortuneService theFortuneService){
//		System.out.println(">> TennisCoach: inside setter theFortuneService");
//		fortuneService = theFortuneService;
//	}


	/*
	 * any method injection example
	 * */
	
// as long as any function is autowired, spring will make use of that to resolve a dependency 
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService){
//		System.out.println(">> TennisCoach: inside setter doSomeCrazyStuff");
//		fortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "practice your backend valley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
