/**
 * 
 */
package poc.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import poc.controller.entity.Product;
import poc.repository.v1.ProductRepository;

/**
 * Controller to serve CRUD operations on Product.
 * 
 * @author bhumireddy
 * @Version: V1
 *
 */
@RestController
@RequestMapping("/product/v1")
@Api(value = "Product Controller", description = "Controller for all CRUD operations on Product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductRepository repository;

	/**
	 * Creates a new product in the database.
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation("Creates new product")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
		product = repository.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	/**
	 * Retrieves a product from database for a given id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation("retrieves a product")
	public ResponseEntity<Product> get(@PathVariable String id){
		Product proudct = repository.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(proudct);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation("retrieves all products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,  consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation("Updates a product")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(product));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,   produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation("deletes a product")
	public ResponseEntity<String> deleteProduct(@PathVariable String id){
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	
}
