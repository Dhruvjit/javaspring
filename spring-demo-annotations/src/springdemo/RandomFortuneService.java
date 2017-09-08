package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] data = {
			"beware of wolf in sheep's clothing",
			"diligence is the mother of luck",
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		// TODO Auto-generated method stub
		return theFortune;
	}

}
