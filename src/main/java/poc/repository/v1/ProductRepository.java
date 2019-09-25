/**
 * 
 */
package poc.repository.v1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import poc.controller.entity.Product;

/**
 * JPA Repository for Product.
 * 
 * @author bhumireddy
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
