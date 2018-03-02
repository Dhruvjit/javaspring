package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config file by creating spring container
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the container
		//Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		
		// default bean id
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		// checking the new Coach
		Coach newCoach = context.getBean("newCoachComponent",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkput());
		System.out.println(newCoach.getDailyWorkput());
		
		// call method to get daily fortune
		// injecting dependency happyfortuneservice.java using autowire
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
