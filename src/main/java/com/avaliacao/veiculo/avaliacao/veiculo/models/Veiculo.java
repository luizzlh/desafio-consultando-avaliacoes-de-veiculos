package com.avaliacao.veiculo.avaliacao.veiculo.models;

public class Veiculo {

    private String marca, modelo, combustivel;
    private int ano;
    private double valor;

//    public Veiculo(Dados dadosVeiculo) {
//        this.marca = dadosVeiculo.marca();
//        this.modelo = dadosVeiculo.modelo();
//        this.combustivel = dadosVeiculo.combustivel();
//        this.ano = dadosVeiculo.ano();
//        this.valor = dadosVeiculo.valor();
//    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combustivel='" + combustivel + '\'' +
                ", ano=" + ano +
                ", valor=" + valor +
                '}';
    }
}
