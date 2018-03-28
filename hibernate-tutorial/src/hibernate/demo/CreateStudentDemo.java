package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session object to save java object
			System.out.println("creating a new student object...");
			Student tempStudent = new Student("paul", "wall", "paul@gmail.com");
			
			// create a student object
			session.beginTransaction();
			
			// start a transaction
			System.out.println("Saving the student....");
			session.save(tempStudent);
			
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
