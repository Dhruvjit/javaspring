package springdemo;

import org.springframework.stereotype.Component;

// this annotation will make spring to make bean for us
// automatically with id = thatSillyCoach
// no two component names of two different class can be same

//if no bean id annotations are given with any name, you can still retrieve it by writing name of class
// starting with first small letter of the actual java class i.e. TennisCoach can also be retrieved by using
// Coach theCoach = context.getBean("tennisCoach", Coach.class);
// but first you need to remove that explicit declaration of bean for spring to make use of default bean id

@Component // or @Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "practice your backend valley";
	}

}
