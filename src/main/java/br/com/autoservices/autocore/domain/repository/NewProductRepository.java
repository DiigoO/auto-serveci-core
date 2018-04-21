package br.com.autoservices.autocore.domain.repository;

import br.com.autoservices.autocore.domain.entities.NewProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewProductRepository extends MongoRepository<NewProduct, String> {
    NewProduct findByNomeProduto(String nomeProduto);
}