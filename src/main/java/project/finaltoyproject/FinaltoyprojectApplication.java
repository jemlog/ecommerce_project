package project.finaltoyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FinaltoyprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinaltoyprojectApplication.class, args);
    }

}
