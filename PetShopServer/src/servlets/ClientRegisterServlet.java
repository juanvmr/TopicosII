package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectionFactory;
import models.ClienteModel;
import dao.ClienteDao;

@WebServlet("/cliente")
public class ClientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static int quantidadeCliente = 0;
	
	Connection connection = ConnectionFactory.getConnection("localhost", "4000", "PetShopServer", "admin", "admin");
	ClienteDao dao = new ClienteDao(connection);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
		case "/cliente/create":
			createCliente(req);
			break;
		case "/cliente/update":
			updateCliente(req);
			break;
		default: resp.sendError(404);
	}
		resp.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void createCliente(HttpServletRequest req) {
		ClienteModel cliente = new ClienteModel();
		cliente.setCPF(req.getAttribute("CPF").toString());
		cliente.setEmail(req.getAttribute("email").toString());
		cliente.setEndereco(req.getAttribute("endereco").toString());
		//cliente.setId(quantidadeCliente);
		cliente.setNome(req.getAttribute("nome").toString());
		
		try {
			dao.insert(cliente);
			//quantidadeCliente++;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCliente(HttpServletRequest req) {
		ClienteModel cliente = new ClienteModel();
		cliente.setNome(req.getAttribute("nome").toString());
		cliente.setEndereco(req.getAttribute("endereco").toString());
		//cliente.setId(quantidadeCliente);
		cliente.setEmail(req.getAttribute("email").toString());
		cliente.setCPF(req.getAttribute("cpf").toString());
		
		try {
			dao.update(cliente);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}