package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

public class DeleteDemo {

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
			
			// get instructor by primary key/id i.e. entry of chad darby is gone
			int theId = 1;
			Instructor tempInstructor = 
					session.get(Instructor.class, theId);
			
			System.out.println("found instructor: " + tempInstructor);
			
			// delete the instructors
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
			
				// note: will also delete associated "details" object
				// because of CascadeType.All
				//
				session.delete(tempInstructor);
				
			}
			
			// commit the transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		//
		
	}

}
