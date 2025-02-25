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
 * lecture 254 many2many create course reviews
 * here we create reviews to assign it to courses
 * and further test the working of the app
 * */
public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("guitar course for one month");
			//Course tempCourse1 = new Course("shit is getting real this time!");
			
			// save the course
			System.out.println("\n Saving the course ...");
			session.save(tempCourse);
			//session.save(tempCourse1);
			
			System.out.println("saved the course " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Ram", "Kumar", "Ram@kumar.com");
			Student tempStudent2 = new Student("pedro", "peterson", "pedro@peterson.com");
			Student tempStudent3 = new Student("michael", "corleone", "godfather@gmail.com");
			
			// e.g. of how to add course to the student
			//tempStudent1.addCourse(tempCourse1);
			
			// e.g. of how to add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			// save the students
			System.out.println("\nSaving students ...");
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			System.out.println("Saved students: " + tempCourse.getStudents());
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
