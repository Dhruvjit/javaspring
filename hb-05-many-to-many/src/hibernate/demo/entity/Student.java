package hibernate.demo.entity;

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
import javax.persistence.Table;

/* lecture 253 - demo of many2many relationship
 * Here we have mapped many2many relationship on List<Students> class 
 * the use of @JoinTable is also demonstrated here which is widely used
 * to map relations between two tables
 */

// annotations for mapping fields in hibernate to database colunms
// here hibernate will consider entity name as default table name, because
// it is not explicitly defined

// we have not given any entity name here also because the table in database has
// the same name as this class name
@Entity
@Table(name="student")
public class Student {
	
	//the name of annotations can be anything but it should match the database table 
	
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
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade= {CascadeType.DETACH,CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH})
		// @joinTable name should match table in mysql database
		// this tells hibernate how to find out the relational mappings defined in Mysql table
		
	// here inverseJoinColumn means pointing to the other side referenced by the student
	// in Student.java side inverseJoinColumn will point to course id and join column will point
	// to student_id
		
	@JoinTable(
		name = "course_student",
		joinColumns = @JoinColumn(name="student_id"),
		inverseJoinColumns=@JoinColumn(name="course_id")
		)
	private List<Course> courses;
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email) {
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
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// this is just for debugging purpose
	public String toString() {
		return "Student [id=" + id + ", firstname=" + 
				firstName + ",lastname=" + lastName +
				", email=" + email;
	}
	
}
