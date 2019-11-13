
package acme.entities.offers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				creationmoment;

	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	private Date				deadline;

	@NotBlank
	private String				text;

	@Valid
	@NotNull
	private Money				moneyMin;

	@Valid
	@NotNull
	private Money				moneyMax;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^O[A-Z]{4}-[0-9]{5}$")
	private String				ticker;

}
