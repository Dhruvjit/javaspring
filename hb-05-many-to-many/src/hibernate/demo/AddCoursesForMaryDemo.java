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
 * lecture 256 many2many add more courses to student
 * here we create more courses and try to add them to student from database
 * */
public class AddCoursesForMaryDemo {

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

			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to speed a cube");
			Course tempCourse2 = new Course("warcraft 3 frozen throne");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("\n Saving the Courses...");
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
