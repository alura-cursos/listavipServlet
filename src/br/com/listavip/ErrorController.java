package br.com.listavip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Analyze the servlet exception
        Exception exception = (Exception)req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer)req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String)req.getAttribute("javax.servlet.error.servlet_name");
        String requestUri = (String)req.getAttribute("javax.servlet.error.request_uri");

        // Set response content type
        resp.setContentType("text/html");

        // print the output
        PrintWriter out = resp.getWriter();
        out.write("<html><head><title>Servlet de Erro</title></head><body>");
        if (statusCode != 500){
            out.write("<h3>Descrição do Erro</h3>");
            out.write("<strong>Código do status</strong>:" + statusCode + "<br>");
            out.write("<strong>URI da requisição</strong>:" + requestUri);
        } else {
            out.write("<h3>Descrição do Erro</h3>");
            out.write("<ul><li>Nome da Servlet: " + servletName + "</li>");
            out.write("<li>Exceção: " + exception.getClass().getName() + "</li>");
            out.write("<li>URI da requisição: " + requestUri + "</li>");
            out.write("<li>Mensagem da exceção: " + exception.getMessage() + "</li>");
            out.write("</ul>");
        }
        out.write("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
