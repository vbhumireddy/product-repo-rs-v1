/**
 * 
 */
package poc.model.v1;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @author bhumireddy
 *
 */
@Data
@Builder
public class ProductCreateRequest implements Serializable {

	private String productId;

	private String name;

	private String type;

	private int price;

	private String location;
}
