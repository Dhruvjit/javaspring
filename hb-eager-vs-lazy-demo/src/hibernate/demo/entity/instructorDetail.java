package hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class instructorDetail {
	
	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	//create constructors
	
	// generate getters/setter method
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail", cascade= {CascadeType.DETACH,CascadeType.MERGE, 
													   CascadeType.PERSIST, CascadeType.REFRESH})
	/* use cascadetype.all to remove all the instructor and instructor detail attached*/
	//@OneToOne(mappedBy = "instructorDetail", cascade=CascadeType.ALL)
	// add new field for instructor (also add getter/setters)
	private Instructor instructor;
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public instructorDetail() {
		
	}
	
	public instructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "instructorDetail [id=" + id + ", youtubeChannel=" + 
				youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
}
