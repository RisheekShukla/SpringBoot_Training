package com.mydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
	@Bean(name="student1")
	public Student getStudent1()
	{
		Student s = new Student();
		s.setStudentid(1);
		s.setStudentname("RIsheek");
		s.setScore(14);
		return s;
	}
	@Bean(name="student2")
	public Student getStudent2()
	{
		Student s = new Student();
		s.setStudentid(2);
		s.setStudentname("murphy");
		s.setScore(12);
		return s;
	}
	@Bean(name="student3")
	public Student getStudent3()
	{
		Student s = new Student();
		s.setStudentid(3);
		s.setStudentname("aayush");
		s.setScore(11);
		return s;
	}
	@Bean(name="college1")
	public College getCollege1()
	{
		College c = new College();
		c.setCity("indore");
		c.setCollegecode(11);
		c.setCollegename("amity");
		return c;
	}
}
