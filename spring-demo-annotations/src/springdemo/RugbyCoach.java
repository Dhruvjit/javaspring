package springdemo;

import org.springframework.stereotype.Component;

// this annotation will make spring to make bean for us
// automatically with id = thatSillyRugbyGame
// spring will create all beans for all the annotations that are provided in the class

@Component("thatSillyRugbyGame")
public class RugbyCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "practice your rugby throw";
	}

}
