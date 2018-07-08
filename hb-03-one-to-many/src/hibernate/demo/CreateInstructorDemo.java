package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.instructorDetail;

public class CreateInstructorDemo {

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
			
			//  create the objects
//			Instructor tempInstructor = 
//					new Instructor("chad", "darby", "darby@luv2code.com");
//			
//			instructorDetail tempInstructorDetail = 
//					new instructorDetail("http://www.luv2code.com/youtube",
//							"kratos motivates dhruvjit");

			Instructor tempInstructor = 
					new Instructor("Dhruvjit", "Bhonsle", "dhruvjit@hotmail.com");
			
			instructorDetail tempInstructorDetail = 
					new instructorDetail("theindianpolitics.com",
							"Guitar Playing");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//note: this will ALSO save the details object because of Cascade.ALL
			System.out.println("saving instructor:" + tempInstructor);
			session.save(tempInstructor);
			
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
