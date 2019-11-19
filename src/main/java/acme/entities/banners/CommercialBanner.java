
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CommercialBanner extends Banner {

	private static final long	serialVersionUID	= 1L;

	@CreditCardNumber
	private long				cardNumber;

	@NotBlank
	private String				holder;

	private int					cvv;

	@NotBlank
	private String				brand;

	@Min(1)
	@Max(12)
	private int					expirationMonth;

	private int					expirationYear;
}
