package me.nsarvar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * @SpringBootApplication – This annotation automatically detects all the @Entity, @Repository,
 * @Controller/ @RestController, @Service and @Component. But all components must be in same
 * or child package level.
 * @ComponentScan – use for scanning the components. Controllers and services can not be identified,
 * if we don’t define the component scan path.
 * @EnableJpaRepositories – use for identified the repositories.
 * @EntityScan – use for identified entities.
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "me.nsarvar")
@EnableJpaRepositories(basePackages = "me.nsarvar.repo")
@EntityScan(basePackages = "me.nsarvar.model")
public class RestWebServiceMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServiceMysqlApplication.class, args);
	}
}
