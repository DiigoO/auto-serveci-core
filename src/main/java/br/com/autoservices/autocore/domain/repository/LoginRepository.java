package br.com.autoservices.autocore.domain.repository;

import br.com.autoservices.autocore.domain.entities.NewUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<NewUser, String> {
    NewUser findByEmailAndPassword(String email, String password);
}
