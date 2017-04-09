/**
 * 
 */
package com.company.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author czz
 *
 */
@Entity
@Table(name="test")
public class TestEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5651085314442206236L;
	
	@Id
	@Column(length = 32, nullable = false, unique = true)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid") 
	private String id;
	
	private String name;
	
	private String age;

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age 要设置的 age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}
	

}
