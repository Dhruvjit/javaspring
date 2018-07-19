package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;
import hibernate.demo.entity.instructorDetail;

/*
 * lecture 258 many2many Get courses for student
 * here we get the courses for the corresponding student id from database
 * later we also tried copying the hibernate query from console and pasting it to sql database
 * to get the result for id we desire to get courses for
 * */
public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(instructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			int studentId = 2;
			
			// get the student uchiha from the database
			Student tempStudent  = session.get(Student.class, studentId);
			
			System.out.println("\n Loaded Student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());

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
