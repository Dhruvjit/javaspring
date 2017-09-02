package springcodes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load the spring configuration file
		// we can load multiple config file by putting comma in 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
	
		// retrieve bean from spring container
		Coach theCoach = context.getBean("baseCoach", Coach.class);
		Coach alphaCoach = context.getBean("baseCoach", Coach.class);
		
		// check if they are same to see difference betwn singleton and protoype
		boolean result = (theCoach==alphaCoach);
		
		// print out results
		System.out.println("pointing out to same object: " + result);
		
		System.out.println("memory location for the theCoach" + theCoach);
		
		System.out.println("memory location for the the theCoach" + alphaCoach);
		
		context.close();
	}

}
