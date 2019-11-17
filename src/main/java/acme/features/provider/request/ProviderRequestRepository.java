
package acme.features.provider.request;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface ProviderRequestRepository extends AbstractRepository {

	@Query("select count(a) from Request a where a.ticker = ?1")
	Integer getTickers(String a);

}
