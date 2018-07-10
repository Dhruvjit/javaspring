package hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	/*
	 * setup mapping to instructor detail*/
	//create constructors
	
	// generate getters/setter method
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	// hookup between instructor table and instructorDetail table
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private instructorDetail instructorDetail;
	
	/*
	 * very imp observation:
	 * 
	 * 1. the connection of course_id to instructor id is already done by sql
	 * hence that's why after using mapped by and join column using Hibernate the program shows
	 * correct instrucotr id in front of courses 
	 * 
	 * 2. mappedBy and joinColumn is extensively used by Hibernate to get the java objects displayed in right
	 * column and place. in short to map them
	 * 
	 * 3. so in this scenario, @joincolumn tells hibernate that hey look at instructor_id in the course column and
	 * use this information to help find associated courses for instructor
	 * 
	 * */
	
	// this refers to "instructor" property in "Course" class 
	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="instructor",
			cascade= {CascadeType.DETACH,CascadeType.MERGE, 
					 CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;
	
	public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public instructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(instructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	// add convinience methods for bi-directional relationship
	public void add(Course tempCourse) {
		if (courses==null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
}
