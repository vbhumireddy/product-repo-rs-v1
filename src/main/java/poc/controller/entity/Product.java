/**
 * 
 */
package poc.controller.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity class.
 * @author bhumireddy
 *
 */
@Document(collection = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
@ApiModel(description = "Product details")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Id
//	private String id;
	
	@ApiModelProperty
	@Id
	private String productId;
	
	@ApiModelProperty
	private String name;
	
	@ApiModelProperty
	private String type;
	
	@ApiModelProperty
	private int price;
	
	@ApiModelProperty
	private String location;
	


	
}
