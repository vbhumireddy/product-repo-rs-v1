/**
 * 
 */
package poc.repository.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import poc.ProductRepoApplication;
import poc.controller.entity.Product;

/**
 * @author bhumireddy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = 
		  SpringBootTest.WebEnvironment.MOCK,
		  classes = ProductRepoApplication.class)
@ContextConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductRepositoryTest {

	@Autowired
	ProductRepository repository;
	
	private static Product product = Product.builder().location("Taiwan").name("laptop").price(1000).build();
	
	
	@Test
	public void t1_testCreateProduct() {
		repository.save(product).getProductId();
		assertNotNull(product.getProductId());
	}
	
	@Test
	public void t2_testGetProduct() {
		assertTrue(repository.findById(product.getProductId()).isPresent());
	}
	
	@Test
	public void t3_testUpdateProduct() {
		Product product_new = Product.builder().location("Taiwan").name("laptop").price(1100).productId(product.getProductId()).build();
		assertEquals(1100,repository.save(product_new).getPrice());
	}
	
	@Test
	public void t4_testDeleteProduct() {
		repository.deleteById(product.getProductId());
		assertFalse(repository.findById(product.getProductId()).isPresent());
	}
}
