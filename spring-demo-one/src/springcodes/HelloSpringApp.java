package springcodes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * in this program we will see how spring does all the objects making and
 * constructor calling and gives us the final result
 */
public class HelloSpringApp {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub //
		
		// load the spring config files
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from spring container
		Coach baseCoach = context.getBean("baseCoach",Coach.class);
		Coach trackCoach = context.getBean("trackCoach",Coach.class);
		
		// call methods on the bean
		System.out.println(baseCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyWorkout());
		
		// call bean method for getting fortune
		System.out.println(trackCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
