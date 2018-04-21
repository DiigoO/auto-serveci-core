package br.com.autoservices.autocore.web.controller;

import br.com.autoservices.autocore.domain.aggregate.NewProductAggregate;
import br.com.autoservices.autocore.domain.aggregate.NewUserAggregate;
import br.com.autoservices.autocore.domain.aggregate.UserLoginAggregate;
import br.com.autoservices.autocore.domain.service.AutoserviceLoginService;
import br.com.autoservices.autocore.domain.service.AutoserviceProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoservicesLoginController {

    @Autowired
    AutoserviceLoginService autoserviceLoginService;

    @Autowired
    AutoserviceProdutoService autoserviceProdutoService;

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/cadastro")
    Boolean cadastroAutoService(@RequestBody NewUserAggregate autoervicesNewUser){
        return autoserviceLoginService.createUser(autoervicesNewUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService")
    Boolean loginAutoService(@RequestBody UserLoginAggregate userLoginAggregate) {
        System.out.println(userLoginAggregate.getEmail());
        return autoserviceLoginService.login(userLoginAggregate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/produto/cadastro")
    Boolean loginAutoService(@RequestBody NewProductAggregate newProductAggregate) {
        return autoserviceProdutoService.createProduct(newProductAggregate);
    }
}
