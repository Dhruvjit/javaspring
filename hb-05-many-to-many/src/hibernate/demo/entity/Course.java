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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/* lecture 252 - demo of many2many relationship
 * Here we have mapped many2many relationship on List<Students> class 
 * the use of @JoinTable is also demonstrated here which is widely used
 * to map relations between two tables
 */

@Entity
@Table(name="course")
public class Course {
	
	// define our fields 
	
	// define constructors
	
	// define getter setters
	
	// define toString
	
	// annotate fields  
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;
	
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
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE, 
				 CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	
	/* * something to notice here is that we dont map course_id column here because
	 * this is unidirectional course->review or one course to many reviews mapping
	 * so follow the rule of @Joincolumn which were discussed in chad's course hence 
	 * the mapping will be done in Course class and not here for course_id
	 * */
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	
	// lec 252 content
	@ManyToOne(fetch = FetchType.LAZY,
				cascade= {CascadeType.DETACH,CascadeType.MERGE, 
						CascadeType.PERSIST, CascadeType.REFRESH})
	
	// @joinTable name should match table in mysql database
	// this tells hibernate how to find out the relational mappings defined in Mysql table
	
	// here inverseJoinColumn means pointing to the other side referenced by the student
	// in Course.java side inverseJoinColumn will point to student_id and join column will point
	// to course_id
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;
	
	// hibernate always needs an empty constructor
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	// add a convinience method
	
	public void addReview(Review theReview) {
		
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(theReview);
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	// add a convenience method
	
	public void addStudent(Student theStudent) {
		
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(theStudent);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
