package modelo;

import java.util.ArrayList;

public class Filme {

	private String titulo;
	private String ano;
	private String nomeDiretor;
	private String localFilmagem;
	private ArrayList<String> genero;
	private ArrayList<String> premios;
	private ArrayList<String> atores;
	

	public Filme(String titulo, String ano, String nomeDiretor, String localFilmagem, ArrayList<String> genero, ArrayList<String> premios, ArrayList<String> atores){
		this.titulo = titulo;
		this.ano = ano;
		this.nomeDiretor = nomeDiretor;
		this.localFilmagem = localFilmagem;
		this.genero = genero;
		this.premios = premios;
		this.atores = atores;
	}
	public Filme(String titulo, String ano, String nomeDiretor, String localFilmagem, ArrayList<String> genero, ArrayList<String> atores){
		this.titulo = titulo;
		this.ano = ano;
		this.nomeDiretor = nomeDiretor;
		this.localFilmagem = localFilmagem;
		this.genero = genero;
		this.atores = atores;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}
	public String getLocalFilmagem() {
		return localFilmagem;
	}
	public void setLocalFilmagem(String localFilmagem) {
		this.localFilmagem = localFilmagem;
	}
	public ArrayList<String> getGenero() {
		return genero;
	}
	public void setGenero(ArrayList<String> genero) {
		this.genero = genero;
	}
	public ArrayList<String> getPremios() {
		return premios;
	}
	public void setPremios(ArrayList<String> premios) {
		this.premios = premios;
	}
	public ArrayList<String> getAtores() {
		return atores;
	}
	public void setAtores(ArrayList<String> atores) {
		this.atores = atores;
	}
}
