package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(instructorDetail.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the Instructor detail object
			int theId = 2;
			instructorDetail tempInstructorDetail = 
					session.get(instructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			/*
			 * before deleting the link with only instructor detail
			 * we must remove the bidirectional link from instructor object to instructor detail
			 * */
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// now let's delete the instructor detail
			// cascade type is set to all so it will also delete the instructor related with instructor
			// detail at given ID
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			// commit the transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
			
		}
		
		// catch any unwanted exception
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			
			// prevent connection leaks by using this code below
			session.close();
			factory.close();
		}
		
	}

}

