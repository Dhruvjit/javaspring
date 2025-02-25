package hibernate.demo;

/*
 * demonstration of Eager vs Lazy laoding
 * udemy episodes 234, 235, 236 
 * 
 * This code presents below mentioned points:
 * 
 * 1. eager vs lazy loading demo
 * 2. resolving lazy loading option 1
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(instructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Kratos: Instructor: " + tempInstructor);		
			
			/* lazy loading option 1 demo */
			// get course for the instructor
			System.out.println("Kratos: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
 			session.getTransaction().commit();
 			
 			// close the session
 			session.close();
 			
 			System.out.println("\n kratos: hey the session is now closed! \n");
 			
 			/* lazy loading option 1 demo */
			// get course for the instructor
			System.out.println("Kratos: Courses: " + tempInstructor.getCourses());
			
			System.out.println("Kratos: Done!");
		}
		finally {
			session.close();
			factory.close();
		}	
	}
}
