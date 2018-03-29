package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			// create 3 student objects
			
			System.out.println("creating a new student object...");
			
			Student tempStudent1 = new Student("lolo", "golo", "lolo@gmail.com");
			Student tempStudent2 = new Student("richard", "bhonsle", "richu@gmail.com");
			Student tempStudent3 = new Student("elizabeth", "bhonsle", "bhenkilodi@gmail.com");
			
			// create a student object
			session.beginTransaction();
			
			// start a transaction
			System.out.println("Saving the student....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
