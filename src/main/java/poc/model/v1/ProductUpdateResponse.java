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
public class ProductUpdateResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productId;
	
	

}
