
package acme.entities.companyRecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	//Serialisation identifier ---------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ----------------------------------------------------------

	@NotBlank
	private String				name;

	private String				sector;

	@NotBlank
	private String				nameCEO;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				website;

	@NotBlank

	@Pattern(regexp = "^(\\+[0-9]{1,3}\\s)?(\\([0-9]{1,4}\\)\\s)?[0-9]{6,10}$")
	private String				phone;

	@NotBlank
	@Email
	private String				email;

	private boolean				incorporated;

	@Min(0)
	@Max(5)
	private Integer				rating;

}
