package br.com.autoservices.autocore.domain.repository;

import br.com.autoservices.autocore.domain.entities.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<UserLogin, String> {
    UserLogin findByEmailAndPasswordEquals(String email, String Password);
}
