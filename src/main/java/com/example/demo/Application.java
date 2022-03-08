package com.example.demo;

import com.example.demo.address.Address;
import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import com.example.demo.course_registration.CourseRegistration;
import com.example.demo.course_registration.CourseRegistrationRepository;
import com.example.demo.item.Item;
import com.example.demo.item.ItemRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository ,
                                        CourseRepository courseRepository,
                                        CourseRegistrationRepository courseRegistrationRepository,
                                        ItemRepository itemRepository) {
        return args -> {
            Student maria = new Student("Maria", "John", "maria@gmail.com", 22);
            Address address = new Address("293 Dien Bien Phu");
            maria.setAddress(address);
            studentRepository.save(maria);

            Course math = new Course("Math");
            courseRepository.save(math);

            CourseRegistration courseRegistration = new CourseRegistration(maria, math);
            courseRegistrationRepository.save(courseRegistration);

            Item item = new Item("Pen", maria);
            itemRepository.save(item);


        };
    }



}
