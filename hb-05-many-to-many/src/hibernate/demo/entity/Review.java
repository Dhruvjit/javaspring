package hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * lecture 243 one2many-unidirectional 
 * here we make Review class which will be pointed by Courses
 * and then we join the desired column of course_id with courses id
 * 
 * something to notice here is that we dont map course_id column here because
 * this is unidirectional course->review or one course to many reviews mapping
 * so follow the rule of @Joincolumn which were discussed in chad's course hence 
 * the mapping will be done in Course class and not here for course_id
 * 
 * 
 * */


@Entity
@Table(name="review")
public class Review {
	
	// define our fields 
	
	// define constructors
	
	// define getter setters
	
	// define toString
	
	// annotate fields 
	
	 /* lecture 243 one2many-unidirectional 
	 * here we make Review class which will be pointed by Courses
	 * and then we join the desired column of course_id with courses id
	 * 
	 * something to notice here is that we dont map course_id column here because
	 * this is unidirectional course->review or one course to many reviews mapping
	 * so follow the rule of @Joincolumn which were discussed in chad's course hence 
	 * the mapping will be done in Course class and not here for course_id
	 */ 
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	
	// hibernate always needs an empty constructor
	public Review() {
		
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
}
