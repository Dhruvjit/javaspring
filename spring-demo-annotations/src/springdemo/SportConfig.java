package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // this is a spring configuration using java code
//@ComponentScan("springdemo") // same component scan as we used with xml file // we dont require atm
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for sad fortune service
	@Bean // here bean id is sadFortuneService which is the method name
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}
	
	// define bean for our swim coach and inject sadFortuneService() dependency in SwimCoach
	@Bean // here bean id is SwimCoach
	public Coach SwimCoach(){
		return new SwimCoach(sadFortuneService());
	}
}
