package br.com.listavip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet("/convidado")
public class ConvidadoServlet extends HttpServlet {

	private static final long serialVersionUID = -2949873189744763662L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");

		Convidado novoConvidado = new Convidado(nome, email, telefone);

		ConvidadoService convidadoService = new ConvidadoService();
		convidadoService.salvar(novoConvidado);

		List<Convidado> convidados = new ConvidadoService().obterTodos();

		req.setAttribute("convidados", convidados);
		req.getRequestDispatcher("/lista.jsp").forward(req, resp);

	}

	public void enviarEmail(Convidado convidado) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			//email.setAuthenticator(new DefaultAuthenticator("email", "password"));
			email.setSSLOnConnect(true);

			email.setFrom("email");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + convidado.getNome() + ". Você acaba de ser convidado pelo ListaVIP.");
			email.addTo(convidado.getEmail());
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
