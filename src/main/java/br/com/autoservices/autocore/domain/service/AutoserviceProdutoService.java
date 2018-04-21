package br.com.autoservices.autocore.domain.service;

import br.com.autoservices.autocore.domain.aggregate.NewProductAggregate;
import br.com.autoservices.autocore.domain.entities.NewProduct;
import br.com.autoservices.autocore.domain.repository.NewProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoserviceProdutoService {
    @Autowired
    NewProductRepository newProductRepository;

    public Boolean createProduct (NewProductAggregate newProductAggregate){
        if(newProductAggregate == null){
            return false;
        }

        NewProduct verifyUserExist = newProductRepository.findByNomeProduto(newProductAggregate.getNomeProduto());
        if(verifyUserExist == null){
            NewProduct saveProduct = new NewProduct();
            saveProduct.setNomeProduto(newProductAggregate.getNomeProduto());
            saveProduct.setValor(newProductAggregate.getValor());
            newProductRepository.save(saveProduct);
            return true;
        }
        return false;

    }
}
