package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.AchaAtor;
import modelo.Ator;
import modelo.ListaFilmes;

/**
 * Servlet implementation class InfoAtor
 */
@WebServlet("/InfoAtor")
public class InfoAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoAtor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String ator = request.getParameter("nome");
			AchaAtor finder = new AchaAtor();
			Ator atorAchado = finder.achaAtor(ator);
			
			System.out.println("ator achado: " + atorAchado);
			request.setAttribute("infoAtor", atorAchado);
			getServletContext().getRequestDispatcher("/infoAtor.jsp").forward(request, response);;
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
