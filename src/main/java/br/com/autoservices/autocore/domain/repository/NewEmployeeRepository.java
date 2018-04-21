package br.com.autoservices.autocore.domain.repository;

import br.com.autoservices.autocore.domain.entities.NewEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEmployeeRepository extends MongoRepository<NewEmployee, String> {
    NewEmployee findByNomeEmployee(String nomeEmployee);
}
