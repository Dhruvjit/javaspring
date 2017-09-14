package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring java config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);

		
		// get the bean from spring container
		SwimCoach swimCoach = context.getBean("SwimCoach", SwimCoach.class);
				
		//call a method on the bean
		System.out.println(swimCoach.getDailyWorkout());
		
		// call method to get the daily fortune. theCoach is tennisCoach here
		System.out.println(swimCoach.getDailyFortune());
				
		// get daily workout from rugby coach
		System.out.println(swimCoach.getDailyWorkout());
		
		// get email from properties file
		System.out.println(swimCoach.getEmail());
		
		// close the context
		context.close();
	}

}
