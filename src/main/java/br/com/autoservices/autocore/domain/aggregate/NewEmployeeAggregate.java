package br.com.autoservices.autocore.domain.aggregate;

public class NewEmployeeAggregate {

    private String nomeEmployee;
    private String salario;
    private String cargo;

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
