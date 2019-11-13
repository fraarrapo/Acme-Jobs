
package acme.features.administrator.customParams;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorConfigurationRepository extends AbstractRepository {

	@Query("select a from Configuration a")
	List<String> findMany();
}
