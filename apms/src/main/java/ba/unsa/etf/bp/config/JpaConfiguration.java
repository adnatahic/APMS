package ba.unsa.etf.bp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"ba.unsa.etf.bp.repository"})
public class JpaConfiguration {

}
