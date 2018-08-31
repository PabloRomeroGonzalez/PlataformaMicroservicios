package pl.piomin.services.organization.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import pl.piomin.services.organization.model.Organization;

public class OrganizationRepository {
	
	@PostConstruct
	private void cargaOrganizaciones() {
		Organization org = new Organization();
		org.setAddress("Madrid, Sevilla y Ubrique");
		org.setId(1l);
		org.setName("LasCumbres Software Design");
	}

	private List<Organization> organizations = new ArrayList<>();
	
	public Organization add(Organization organization) {
		organization.setId((long) (organizations.size()+1));
		organizations.add(organization);
		return organization;
	}
	
	public Organization findById(Long id) {
		Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (organization.isPresent())
			return organization.get();
		else
			return null;
	}
	
	public List<Organization> findAll() {
		return organizations;
	}
	
}
