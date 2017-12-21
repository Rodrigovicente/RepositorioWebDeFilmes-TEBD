package modelo;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.jena.iri.impl.Main;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class AchaAtor {
	static final String inputFileName  = "C:/Users/rodri/workspace/TEBD-Trab2/WebContent/baseFilmes.rdf";
	static final String atorBaseLocation = "http://localhost:3030/tebd-trab2/query";
	
	public static Ator achaAtor(String nomeCompleto){		
		
		Model model = ModelFactory.createDefaultModel();
		Ator ator = new Ator(null, null, null, null);

	    InputStream in = FileManager.get().open( inputFileName );
	    if (in == null) {
	        throw new IllegalArgumentException( "File: " + inputFileName + " not found");
	    }
	    
	    //model.read(in, "");
	    
	    //model.write(System.out);
	    
	    FileManager.get().addLocatorClassLoader(Main.class.getClassLoader());
	    model = FileManager.get().loadModel(inputFileName);
	    
	    String sparql =   "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	    			  	+ "PREFIX	vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> "
			    		+ "SELECT ?nomeCompleto ?premios ?conjuge ?filho ?nascimento ?nacionalidade ?enderecoAtual ?filmes ?lista"
			    		+ " WHERE "
			    		+ "{ ?x vcard:FN ?nomeCompleto . "
			    		+ "	?x vcard:Family ?conjuge ."
			    		+ "	?x vcard:NAME ?filho ."
			    		+ "	?x vcard:BDAY ?nascimento ."
			    		+ "	?x vcard:Country ?nacionalidade ."
			    		+ "	?x vcard:Locality ?enderecoAtual ."
			    		+ "	?x vcard:CATEGORIES ?premios ."
			    		+ "FILTER(?nomeCompleto = \""+nomeCompleto+"\")"
			    		+ "}";
	    
	    String sparqlPremios =   "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			  	+ "PREFIX	vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> "
	    		+ "SELECT * WHERE {"
	    		+ "	?x vcard:CATEGORIES ?premios ."
	    		+ "FILTER(?nomeCompleto = \""+nomeCompleto+"\")"
	    		+ "}";
	    
	    Query query = QueryFactory.create(sparql);
//	    Query queryPremios = QueryFactory.create(sparqlPremios);
	    
	    QueryExecution qexec = QueryExecutionFactory.sparqlService(atorBaseLocation, sparql);
//	    QueryExecution qexecPremios = QueryExecutionFactory.sparqlService("http://localhost:3030/tebd-trab2/query", sparqlPremios);
	    

		/*ArrayList<String> listaPremios = new ArrayList<String>();
		ResultSet resultsPremios;
		QuerySolution querySol;
		Literal valor;*/
	    
	    try {
			ResultSet results = qexec.execSelect();
			while ( ((org.apache.jena.query.ResultSet) results).hasNext() ) {
				QuerySolution soln = (results).nextSolution();
				Literal nome = soln.getLiteral("nomeCompleto");
				Literal premios = soln.getLiteral("premios");
				Literal conjuge = soln.getLiteral("conjuge");
				Literal filho = soln.getLiteral("filho");
				Literal nascimento = soln.getLiteral("nascimento");
				Literal nacionalidade = soln.getLiteral("nacionalidade");
				Literal enderecoAtual = soln.getLiteral("enderecoAtual");
				

				/*try {
					resultsPremios = qexecPremios.execSelect();
					while (resultsPremios.hasNext()) {
						querySol = resultsPremios.nextSolution();
						valor = querySol.getLiteral("x");

						listaPremios.add(valor.toString());
					}
				} 
				finally {
					qexecPremios.close();
				}*/
				
				ator = new Ator(nome.toString(), nascimento.toString(), nacionalidade.toString(), enderecoAtual.toString(), premios.toString());
				
				System.out.println("nome ator: " + ator.getNome());
				
				//Literal name8 = soln.getLiteral("filmes");
				System.out.println("Nome: " + nome);
				System.out.println("Prêmios: " + premios);
				System.out.println("Cônjuge: " + conjuge);
				System.out.println("Filho: " + filho);
				System.out.println("Data de Nascimento: " + nascimento);
				System.out.println("Nacionalidade " + nacionalidade);
				System.out.println("Endereço Atual: " + enderecoAtual);
				//System.out.println("Filmes: " + name8);
				//System.out.println("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	    qexec.close();
	    
		return ator;
	}
	public static void main(String[] args){
		achaAtor("William Bradley Pitt");
	}
}
