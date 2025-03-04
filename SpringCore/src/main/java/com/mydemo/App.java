package com.mydemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(StudentConfiguration.class);
//    	Student s = (Student)cont.getBean("student1");
//    	System.out.println("Student name is "+s.getStudentname());
//    	System.out.println("Score is "+s.getScore());
    	College c = (College)cont.getBean("college1");
    	System.out.println("College name is "+c.getCollegename());
    	List<Student>slist = c.getStulist();
    	for(Student st:slist)
    	{
    		System.out.println("Student name is "+st.getStudentname());
    	}
    }
}
