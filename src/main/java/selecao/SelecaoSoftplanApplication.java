package selecao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
//@EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class})
//@EnableAutoConfiguration(exclude = {LiquibaseProperties.class, ApplicationProperties.class})
public class SelecaoSoftplanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelecaoSoftplanApplication.class, args);
    }

}
