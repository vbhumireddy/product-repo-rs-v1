/**
 * 
 */
package poc.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

import com.mongodb.MongoClient;

//import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

/**
 * Class to declare common beans.
 * 
 * @author bhumireddy
 *
 */
@Configuration
public class CommonsConfiguration {

	private static final String MONGO_DB_URL = "localhost";
    private static final String MONGO_DB_NAME = "embeded_db";
    
	@Bean
	public RestTemplate restTempate() {
		return new RestTemplate();
	}

//	@Bean
//	public MongoTemplate mongoTemplate() throws IOException {
//		EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//		mongo.setBindIp(MONGO_DB_URL);
//		MongoClient mongoClient = mongo.getObject();
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
//		return mongoTemplate;
//	}
}
