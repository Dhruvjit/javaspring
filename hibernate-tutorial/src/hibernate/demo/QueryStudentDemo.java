package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			session.beginTransaction();
			
			// query students, here Student is class name
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
//			// query students: firstName = 'donald' or lastname = 'bhonsle'
//			theStudents = session.createQuery("from Student s where" 
//							+ " s.lastName='bhonsle' OR s.firstName='donald'").getResultList();
			
			// query students: firstName = 'donald' or lastname = 'bhonsle'
			theStudents = session.createQuery("from Student s where" 
							+ " s.email LIKE '%gmail.com'").getResultList();
						
						
			// display the students
			System.out.println("\n\n students with last name bhonsle or first name richard");
			displayStudents(theStudents);
						
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		//
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

}
