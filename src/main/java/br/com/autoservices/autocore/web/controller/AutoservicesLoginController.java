package br.com.autoservices.autocore.web.controller;

import br.com.autoservices.autocore.domain.aggregate.NewEmployeeAggregate;
import br.com.autoservices.autocore.domain.aggregate.NewProductAggregate;
import br.com.autoservices.autocore.domain.aggregate.NewUserAggregate;
import br.com.autoservices.autocore.domain.aggregate.UserLoginAggregate;
import br.com.autoservices.autocore.domain.entities.NewEmployee;
import br.com.autoservices.autocore.domain.entities.NewProduct;
import br.com.autoservices.autocore.domain.service.AutoserviceEmployeeService;
import br.com.autoservices.autocore.domain.service.AutoserviceLoginService;
import br.com.autoservices.autocore.domain.service.AutoserviceProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoservicesLoginController {

    @Autowired
    AutoserviceLoginService autoserviceLoginService;

    @Autowired
    AutoserviceProdutoService autoserviceProdutoService;

    @Autowired
    AutoserviceEmployeeService autoserviceEmployeeService;

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/cadastro")
    Boolean createUser(@RequestBody NewUserAggregate autoervicesNewUser){
        return autoserviceLoginService.createUser(autoervicesNewUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService")
    Boolean login(@RequestBody UserLoginAggregate userLoginAggregate) {
        return autoserviceLoginService.login(userLoginAggregate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/produto/cadastro")
    Boolean createProduct(@RequestBody NewProductAggregate newProductAggregate) {
        return autoserviceProdutoService.createProduct(newProductAggregate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/core-login/autoService/produto/lista")
    List<NewProduct> listProducts(){
        return autoserviceProdutoService.listProducts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/core-login/autoService/employee/cadastro")
    Boolean createEmployee(@RequestBody NewEmployeeAggregate newEmployeeAggregate) {
        return autoserviceEmployeeService.createEmployee(newEmployeeAggregate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/core-login/autoService/employee/lista")
    List<NewEmployee> listEmployee(){
        return autoserviceEmployeeService.listEmployee();
    }
}
