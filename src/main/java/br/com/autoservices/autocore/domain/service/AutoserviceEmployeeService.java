package br.com.autoservices.autocore.domain.service;

import br.com.autoservices.autocore.domain.aggregate.NewEmployeeAggregate;
import br.com.autoservices.autocore.domain.aggregate.NewProductAggregate;
import br.com.autoservices.autocore.domain.entities.NewEmployee;
import br.com.autoservices.autocore.domain.entities.NewProduct;
import br.com.autoservices.autocore.domain.repository.NewEmployeeRepository;
import br.com.autoservices.autocore.domain.repository.NewProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoserviceEmployeeService {
    @Autowired
    NewEmployeeRepository newEmployeeRepository;

    public Boolean createEmployee (NewEmployeeAggregate newEmployeeAggregate){
        if(newEmployeeAggregate == null){
            return false;
        }

        NewEmployee verifyEmployeeExist = newEmployeeRepository.findByNomeEmployee(newEmployeeAggregate.getNomeEmployee());
        if(verifyEmployeeExist == null){
            NewEmployee saveEmployee = new NewEmployee();
            saveEmployee.setNomeEmployee(newEmployeeAggregate.getNomeEmployee());
            saveEmployee.setCargo(newEmployeeAggregate.getCargo());
            saveEmployee.setSalario(newEmployeeAggregate.getSalario());
            newEmployeeRepository.save(saveEmployee);
            return true;
        }
        return false;

    }

    public List<NewEmployee> listEmployee(){
        return newEmployeeRepository.findAll();
    }
}
