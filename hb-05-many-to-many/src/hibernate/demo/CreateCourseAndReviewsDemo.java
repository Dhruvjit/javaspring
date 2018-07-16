package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.instructorDetail;

/*
 * lecture 245 One2Many unidirectional create course reviews
 * here we create reviews to assign it to courses
 * and further test the working of the app
 * */
public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(instructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
								
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Cricket - how to score million points");
			
			/* here course id is taken from the mysql database i.e. 10*/
			// add some reviews
			tempCourse.addReview(new Review("Great course..loved it!"));
			tempCourse.addReview(new Review("Hit the bat..Kill the bowler!"));
			tempCourse.addReview(new Review("ball mera gum ho gaya bhenchod!"));
			
			// save the course... and leverage the cascade all :)
			System.out.println("saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
