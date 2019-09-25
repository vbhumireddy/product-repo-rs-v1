/**
 * 
 */
package poc.controller.v1;

import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import poc.controller.entity.Product;
import poc.repository.v1.ProductRepository;

/**
 * @author bhumireddy
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductRepoControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductRepository repository;

	private static Product product = Product.builder().location("Taiwan").name("laptop").price(1000).build();

	@Test
	public void t1_createProduct() throws Exception {

		Mockito.when(repository.save(ArgumentMatchers.any(Product.class)))
				.thenReturn(product.toBuilder().productId("1").build());
		mvc.perform(MockMvcRequestBuilders.post("/product/v1/").content(asJsonString(product))
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andExpect(status().isCreated());
	}

	@Test
	public void t2_getProduct() throws Exception {

		Mockito.when(repository.findById(ArgumentMatchers.any(String.class)))
				.thenReturn(Optional.of(product.toBuilder().productId("1").build()));
		mvc.perform(MockMvcRequestBuilders.get("/product/v1/1").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void t3_updateProduct() throws Exception {

		Mockito.when(repository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
		mvc.perform(MockMvcRequestBuilders.put("/product/v1/1").content(asJsonString(product))
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void t4_deleteProduct() throws Exception {

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		}).when(repository).deleteById(ArgumentMatchers.anyString());
		mvc.perform(MockMvcRequestBuilders.delete("/product/v1/1").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
