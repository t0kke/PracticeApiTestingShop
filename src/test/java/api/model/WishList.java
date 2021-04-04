package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WishList {

	@JsonProperty("updatetopwishlistsectionhtml")
	private String updatetopwishlistsectionhtml;

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("message")
	private String message;
}