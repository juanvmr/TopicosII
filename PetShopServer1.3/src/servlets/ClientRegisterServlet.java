package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ClienteModel;

@WebServlet("/Register/Client")
public class ClientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int quantidadeCliente = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("cliente"+quantidadeCliente, createClient(request));
		quantidadeCliente++;
		response.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private ClienteModel createClient(HttpServletRequest req) {
		ClienteModel cliente = new ClienteModel();
		cliente.setCPF(req.getAttribute("CPF").toString());
		cliente.setEmail(req.getAttribute("email").toString());
		cliente.setEndereco(req.getAttribute("endereco").toString());
		cliente.setId(quantidadeCliente);
		cliente.setNome(req.getAttribute("nome").toString());
		
		return cliente;
	}

}