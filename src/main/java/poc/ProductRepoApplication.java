/**
 * 
 */
package poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author bhumireddy
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"poc"})
public class ProductRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRepoApplication.class, args);
	}
}
