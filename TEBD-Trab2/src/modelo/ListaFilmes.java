package modelo;

import java.util.ArrayList;

public class ListaFilmes {
	private ArrayList<Filme> listaFilmes;


	public void AddFilme(Filme filme){
		this.listaFilmes.add(filme);
	}
	
	public void AddFilme(ArrayList<Filme> filmes){
		this.listaFilmes.addAll(filmes);
	}
	
	public Filme getFilme(int index){
		return this.listaFilmes.get(index);
	}
	
	public ArrayList<Filme> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(ArrayList<Filme> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}
	
}
