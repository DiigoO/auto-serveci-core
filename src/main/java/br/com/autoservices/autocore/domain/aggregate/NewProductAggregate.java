package br.com.autoservices.autocore.domain.aggregate;

public class NewProductAggregate {

    private String nomeProduto;
    private String valor;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
