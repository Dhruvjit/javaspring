package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

public class DeleteCourseDemo {

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
			
			// get the course from database
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// delete the course from the database
			System.out.println("Deleting Course: " + tempCourse);
			
			session.delete(tempCourse);
			
			// commit the transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
			
		}
		finally {
			session.close();
			factory.close();
		}	
	}
}
