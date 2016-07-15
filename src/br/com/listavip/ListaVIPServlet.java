package br.com.listavip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/listavip")
public class ListaVIPServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = -343835029239869286L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Convidado> listaDeConvidados = new ConvidadoService().obterListaDeConvidados();
        
		req.setAttribute("lista", listaDeConvidados);
        req.getRequestDispatcher("/lista.jsp").forward(req, resp);
    
	}

}
