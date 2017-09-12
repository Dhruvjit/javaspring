package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
	
		// get the bean from spring container
		// if no bean id annotations are given with any name, you can still retrieve it by writing name of class
		// starting with first small letter of the actual java class i.e. TennisCoach can also be retrieved by using
		// Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// but first you need to remove that explicit declaration of bean for spring to make use of default bean id
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// get the bean from spring container
		Coach rugbyCoach = context.getBean("thatSillyRugbyGame", Coach.class);
				
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(rugbyCoach.getDailyWorkout());
		
		// call method to get the daily fortune. theCoach is tennisCoach here
		System.out.println(theCoach.getDailyFortune());
		
		// get the bean from spring container
		SwimCoach swimCoach = context.getBean("michaelPhelps", SwimCoach.class);
		
		System.out.println(swimCoach.getEmail());
		
		// close the context
		context.close();
	}

}
