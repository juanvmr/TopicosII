package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AgendamentoModel;
import dao.AgendamentoDao;
import dao.ConnectionFactory;

@WebServlet("/agendamento")
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static int quantidadeAgendamento = 0;
	
	Connection connection = ConnectionFactory.getConnection("localhost", "4000", "PetShopServer", "admin", "admin");
	AgendamentoDao dao = new AgendamentoDao(connection);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		switch(req.getServletPath()) {
			case "/agendamento/create":
				createAgendamento(req);
				break;
			case "/agendamento/update":
				updateAgendamento(req);
				break;
			default: resp.sendError(404);
		}
		resp.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void createAgendamento(HttpServletRequest req) {
		AgendamentoModel agendamento = new AgendamentoModel();
		agendamento.setAnimal(req.getAttribute("animal").toString());
		agendamento.setDate(req.getAttribute("data").toString());
		//agendamento.setSchedulingID(quantidadeAgendamento);
		agendamento.setService(req.getAttribute("servico").toString());
		
		try {
			dao.insert(agendamento);
			//quantidadeAgendamento++;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	private void updateAgendamento(HttpServletRequest req) {
		AgendamentoModel agendamento = new AgendamentoModel();
		agendamento.setAnimal(req.getAttribute("animal").toString());
		agendamento.setDate(req.getAttribute("data").toString());
		//agendamento.setSchedulingID(quantidadeAgendamento);
		agendamento.setService(req.getAttribute("servico").toString());
		
		try {
			dao.update(agendamento);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}