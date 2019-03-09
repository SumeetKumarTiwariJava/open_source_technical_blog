package com.opensource.technical.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
	
	private String empName;
	
	private String companyName;
	
	private int empAge;

}
