package com.alzain.schooltimetable;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Service.GradeWClassService;
import com.alzain.schooltimetable.Service.SubjectService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolTimeTableApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(SchoolTimeTableApplication.class, args);


		Object dataSource = context.getBean("dataSource");
		System.out.println(dataSource);
	}



	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			System.out.println("inspecting beans running by spring Application");
			String[] beanNames = context.getBeanDefinitionNames();
		};
	}


}
