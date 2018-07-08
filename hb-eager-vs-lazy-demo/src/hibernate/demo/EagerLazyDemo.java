package hibernate.demo;

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
			
			// get course for the instructor
			System.out.println("Kratos: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
 			session.getTransaction().commit();
 			
 			// close the session
 			session.close();
 			
 			System.out.println("\n kratos: hey the session is now closed! \n");
 			
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
