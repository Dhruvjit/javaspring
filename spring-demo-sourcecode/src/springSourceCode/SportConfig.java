package springSourceCode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// uncomment componentscan if you want to run program using annotation
//@ComponentScan("springSourceCode")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		
		// returning swimcoach using constructor method
		return new SwimCoach(sadFortuneService());
		
//		// returning swimcoach using setter injection method
//		SwimCoach swimcoach = new SwimCoach();
//		swimcoach.setFortuneService(sadFortuneService());
//		return swimcoach; //
		
	}
	
	
}
