package springdemo;

import org.springframework.stereotype.Component;

// this can be component of any name
@Component("newCoachComponent")
public class NewCoach implements Coach {

	@Override
	public String getDailyWorkput() {
		
		return "I am the new coach. bitch!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeam() {
		// TODO Auto-generated method stub
		return null;
	}

}
