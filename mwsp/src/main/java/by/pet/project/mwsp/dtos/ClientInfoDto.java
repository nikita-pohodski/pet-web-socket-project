package by.pet.project.mwsp.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientInfoDto {

	@ApiModelProperty()
	private String email;

	@ApiModelProperty()
	private String firstname;

	@ApiModelProperty()
	private String lastname;

}
