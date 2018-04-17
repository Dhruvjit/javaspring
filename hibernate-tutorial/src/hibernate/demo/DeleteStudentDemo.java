package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId=4;
			
			////////////////////////// read object from database /////////////////////////

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("Getting the student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
//			// updating the student name according to the ID in the sql tabl
//			System.out.println("updating student....");
//			myStudent.setFirstName("Scooby");
//			
//			System.out.println("Get complete: " + myStudent);
//			
//			// commit the transaction
//			session.getTransaction().commit();
//			
//			
//			///////////////////////// Deleteing objects using hibernate//////////////
//						
//			session = factory.getCurrentSession();
//			session.beginTransaction();
			
			// delete the student
			System.out.println("Deleting Student: " + myStudent);
			session.delete(myStudent);
			
			// another way to delete the objects
			//session.createQuery("delete from Student where id=2")
			//.executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
			}
		
			finally {
				
				factory.close();
			
			}
		//
		
	}

}
