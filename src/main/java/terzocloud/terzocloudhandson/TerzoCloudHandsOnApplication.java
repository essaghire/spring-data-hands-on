package terzocloud.terzocloudhandson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("terzo.rest.*")
@EntityScan("terzo.rest.*")
public class TerzoCloudHandsOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerzoCloudHandsOnApplication.class, args);
    }

}
