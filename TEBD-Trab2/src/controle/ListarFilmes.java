package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import modelo.Filme;
import modelo.ListaFilmes;

/**
 * Servlet implementation class listaFilmes
 */
@WebServlet("/ListarFilmes")
public class ListarFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarFilmes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ListaFilmes filmes = new ListaFilmes();
			ArrayList<Filme> listaFilmes = filmes.getListaFilmes();
	
			request.setAttribute("filmes", listaFilmes);
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
