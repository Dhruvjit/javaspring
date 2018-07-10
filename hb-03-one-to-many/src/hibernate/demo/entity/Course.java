package hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	// hibernate always needs an empty constructor
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}
