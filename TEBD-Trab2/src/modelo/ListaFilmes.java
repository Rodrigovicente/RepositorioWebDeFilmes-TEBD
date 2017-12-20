package modelo;

import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.util.FileManager;
import org.apache.jena.rdf.model.*;

public class ListaFilmes {
	
	private ArrayList<Filme> listaFilmes;

	static private String arqRDF = "C:/Users/rodri/workspace/TEBD-Trab2/WebContent/baseFilmes.rdf";
	
	
	public ListaFilmes(){
		this.listaFilmes = new ArrayList<Filme>();
		lerFilmes();
	}

	public void lerFilmes(){
		
		FileManager.get().addLocatorClassLoader(Filme.class.getClassLoader());
		Model model = FileManager.get().loadModel(arqRDF);

		String myQuery = getQuery();
		
		Query queryFilmes, queryGen;
		QueryExecution queryExec, queryExecInt;
		ResultSet results, resultsInt;
		QuerySolution querySol,querySolInt;
		Literal valor;
		
		String titulo = null, ano = null, diretor = null, local = "Terra";
		ArrayList<String> generos = new ArrayList<String>();
		ArrayList<String> premios = new ArrayList<String>();
		ArrayList<String> atores = new ArrayList<String>();
		
		queryFilmes = QueryFactory.create(myQuery);
		queryExec = QueryExecutionFactory.create(queryFilmes, model);
		try {
			results = queryExec.execSelect();
			while (results.hasNext() ) {
				querySol = results.nextSolution();
				valor = querySol.getLiteral("x");

				titulo = valor.toString();
				System.out.println("Filme: " + titulo);
				
				System.out.println("Atores: ");
				
				queryGen = QueryFactory.create(getQuery("atores", titulo));
				queryExecInt = QueryExecutionFactory.create(queryGen, model);
				try {
					resultsInt = queryExecInt.execSelect();
					while (resultsInt.hasNext() ) {
						querySolInt = resultsInt.nextSolution();
						valor = querySolInt.getLiteral("x");
						System.out.println(">> " + valor);
						
						atores.add(valor.toString());
					}
				}	
				finally {
					queryExecInt.close();
				}

				System.out.println("Generos: ");
				
				queryGen = QueryFactory.create(getQuery("generos", titulo));
				queryExecInt = QueryExecutionFactory.create(queryGen, model);
				try {
					resultsInt = queryExecInt.execSelect();
					while (resultsInt.hasNext() ) {
						querySolInt = resultsInt.nextSolution();
						valor = querySolInt.getLiteral("x");
						System.out.println(">> " + valor);
						
						generos.add(valor.toString());
					}
				}	
				finally {
					queryExecInt.close();
				}

				System.out.println("Premios: ");
				
				queryGen = QueryFactory.create(getQuery("premios", titulo));
				queryExecInt = QueryExecutionFactory.create(queryGen, model);
				try {
					resultsInt = queryExecInt.execSelect();
					while (resultsInt.hasNext() ) {
						querySolInt = resultsInt.nextSolution();
						valor = querySolInt.getLiteral("x");
						System.out.println(">> " + valor);
						
						premios.add(valor.toString());
					}
				}	
				finally {
					queryExecInt.close();
				}

				queryGen = QueryFactory.create(getQuery("diretor", titulo));
				queryExecInt = QueryExecutionFactory.create(queryGen, model);
				try {
					resultsInt = queryExecInt.execSelect();
					while (resultsInt.hasNext() ) {
						querySolInt = resultsInt.nextSolution();
						valor = querySolInt.getLiteral("x");
						
						diretor = valor.toString();
					}
				}	
				finally {
					queryExecInt.close();
				}

				System.out.println("Diretor: " + diretor.toString());
				
				queryGen = QueryFactory.create(getQuery("ano", titulo));
				queryExecInt = QueryExecutionFactory.create(queryGen, model);
				try {
					resultsInt = queryExecInt.execSelect();
					while (resultsInt.hasNext() ) {
						querySolInt = resultsInt.nextSolution();
						valor = querySolInt.getLiteral("x");
						
						ano = valor.toString();
					}
				}	
				finally {
					queryExecInt.close();
				}
				
				System.out.println("Ano: " + ano.toString());
				
				listaFilmes.add(new Filme(titulo, ano, diretor, local, (ArrayList<String>) generos.clone(), (ArrayList<String>) premios.clone(), (ArrayList<String>) atores.clone()));
				
				generos.clear();
				premios.clear();
				atores.clear();
				
				System.out.println("-------------------------------------- \n");			
			}
		}	
		finally {
			queryExec.close();
		}
		
	}
	
	
	public String getQuery(){

		String query = 
			"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
				
				"SELECT * WHERE{"+
				"?movie vcard:TITLE ?x"+
				"}";
		
		return query;
	}
	
	public String getQuery(String valor, String filme){

		String query;
		
		switch(valor){
		case "atores":
			query = 
				"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
					
					"SELECT * WHERE{"+
					"?actor vcard:LABEL ?x ."+
					"?movie vcard:hasRole ?actor ."+
					"?movie vcard:TITLE ?y ."+
					"FILTER(?y = \"" + filme + "\")"+
					"}";
			break;
		case "generos":
			query = 
				"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
					
					"SELECT * WHERE{"+
					"?genre vcard:LABEL ?x ."+
					"?movie vcard:hasGender ?genre ."+
					"?movie vcard:TITLE ?y ."+
					"FILTER(?y = \"" + filme + "\")"+
					"}";
			break;
		case "premios":
			query = 
			"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
				
				"SELECT * WHERE{"+
				"?genre vcard:LABEL ?x ."+
				"?movie vcard:CATEGORIES ?genre ."+
				"?movie vcard:TITLE ?y ."+
				"FILTER(?y = \"" + filme + "\")"+
				"}";
			break;
		case "diretor":
			query = 
			"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
				
				"SELECT * WHERE{"+
				"?movie vcard:FN ?x ."+
				"?movie vcard:TITLE ?y ."+
				"FILTER(?y = \"" + filme + "\")"+
				"}";
			break;
		case "ano":
			query = 
			"PREFIX vcard:   <http://www.w3.org/2001/vcard-rdf/3.0#>"+
				
				"SELECT * WHERE{"+
				"?movie vcard:BDAY ?x ."+
				"?movie vcard:TITLE ?y ."+
				"FILTER(?y = \"" + filme + "\")"+
				"}";
			break;
		default:
			query = "";
			
		}
		
		return query;
	}
	
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
	
	/*public static void main(String[] args){
		ListaFilmes filmes = new ListaFilmes();
		
		ArrayList<Filme> filmesLista = filmes.getListaFilmes();
		if(filmesLista.isEmpty()){
			System.out.println("Tá vazio");
		} else{
			System.out.println("Tem coisa");
			System.out.println(filmesLista.get(2).getTitulo());
		
		}
	}*/
	
	
}
