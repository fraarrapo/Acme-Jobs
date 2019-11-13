
package acme.features.anonymous.companyrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousCompanyRecordRepository extends AbstractRepository {

	@Query("select cr from CompanyRecord cr where cr.id = ?1")
	CompanyRecord findOneById(int id);

	@Query("select cr from CompanyRecord cr")
	Collection<CompanyRecord> findManyAll();

	@Query("select cr from CompanyRecord cr where cr.rating = 5")
	Collection<CompanyRecord> findTopCompanies();

}
