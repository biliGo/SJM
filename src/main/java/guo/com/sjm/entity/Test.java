package guo.com.sjm.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "test", catalog = "test")
public class Test implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(String name, Timestamp time) {
		this.name = name;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}