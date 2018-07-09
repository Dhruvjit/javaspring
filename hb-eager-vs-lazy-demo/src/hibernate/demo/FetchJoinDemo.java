package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

/*
 * demonstration of Eager vs Lazy laoding
 * udemy episodes 237 
 * 
 * This code presents below mentioned points:
 * 
 * 1. resolving lazy loading option 2: using HQL join fetch
 */

public class FetchJoinDemo {

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
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", 
						Instructor.class);
			
			//Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Kratos: Instructor: " + tempInstructor);		
			
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
