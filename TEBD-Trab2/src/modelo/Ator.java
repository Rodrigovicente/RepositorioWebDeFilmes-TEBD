package modelo;

import java.util.ArrayList;

public class Ator {

	private String nome;
	private String dataNasc;
	private String paisOrigem;
	private String endereco;
	private ArrayList<String> premios;
	
	
	public Ator(String nome, String dataNasc, String paisOrigem, String endereco, ArrayList<String> premios) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.paisOrigem = paisOrigem;
		this.endereco = endereco;
		this.premios = premios;
	}
	
	public Ator(String nome, String dataNasc, String paisOrigem, String endereco) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.paisOrigem = paisOrigem;
		this.endereco = endereco;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<String> getPremios() {
		return premios;
	}
	public void setPremios(ArrayList<String> premios) {
		this.premios = premios;
	}
	
}
