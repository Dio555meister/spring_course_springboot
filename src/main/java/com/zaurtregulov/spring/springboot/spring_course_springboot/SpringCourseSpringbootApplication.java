package com.zaurtregulov.spring.springboot.spring_course_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// чтобы явно указат какие пакеты сканируем пишем @@SpringBootApplication(scanBasePackages = " ")
@SpringBootApplication //@Configurations, @EnableAutoConfigurations, @ComponentScan
public class SpringCourseSpringbootApplication {

    public static void main(String[] args) {

//Запускается приложение-> создается спринг контейнер->сканирование, поиск бинов и их регистрация в спринг контейнер->
// поднимается томкат сервер-> приложение запускается
        SpringApplication.run(SpringCourseSpringbootApplication.class, args);
    }

}
