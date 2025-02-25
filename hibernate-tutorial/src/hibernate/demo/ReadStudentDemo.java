package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("donald", "trump", "build@wall.mexico");
			
			// create a student object
			session.beginTransaction();
			
			// start a transaction
			System.out.println("Saving the student....");
			System.out.println("tempStudent class: " + tempStudent);
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			////////////////////////// read object from database /////////////////////////
			
			
			// New Code to retrieve or read object from the database
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("Getting the student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
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
