package br.com.autoservices.autocore.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class NewEmployee {
    @Id
    private String id;
    private String nomeEmployee;
    private String salario;
    private String cargo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeEmployee() {
        return nomeEmployee;
    }

    public void setNomeEmployee(String nomeEmployee) {
        this.nomeEmployee = nomeEmployee;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
