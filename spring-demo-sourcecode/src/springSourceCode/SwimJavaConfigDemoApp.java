package springSourceCode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);

		// default bean id
		Coach theCoach = context.getBean("swimCoach",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkput());
		
		// call method to get daily fortune
		// injecting dependency happyfortuneservice.java using autowire
		System.out.println(theCoach.getDailyFortune());
		
		// injecting dependency from properties file 
		System.out.println(theCoach.getTeam());
		
		// injecting dependency from properties file 
		System.out.println(theCoach.getEmail());
				
		// close the context
		context.close();
		
	}

}
