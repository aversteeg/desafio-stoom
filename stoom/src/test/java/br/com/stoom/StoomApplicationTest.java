package br.com.stoom;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoomApplication.class)
@TestPropertySource(locations="classpath:application.properties")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"br.com.stoom.respositories"})

@ComponentScan 
public class StoomApplicationTest {

	@Test
	public void contextLoads() {
	}

}
