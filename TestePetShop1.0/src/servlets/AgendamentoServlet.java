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

@WebServlet({"/agendamento", "/agendamento/create", "/agendamento/update", "/agendamento/delete"})
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static int quantidadeAgendamento = 0;
	
	Connection connection = ConnectionFactory.getConnection("PetShopServer", "admin", "admin");
	AgendamentoDao dao = new AgendamentoDao(connection);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		switch(req.getServletPath()) {
			case "/agendamento/create":
				createAgendamento(req);
				resp.sendRedirect("index.jsp");
				break;
			case "/agendamento/update":
				updateAgendamento(req);
				resp.sendRedirect("index.jsp");
				break;
			case "/agendamento/delete":
				deleteAgendamento(req);
				resp.sendRedirect("index.jsp");
				break;
			case "/agendamento":
				req.getRequestDispatcher("agendamento.jsp").forward(req, resp);
				//resp.sendRedirect("agendamento.jsp");
				break;
			default: resp.sendError(404);
		}
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
	
	private void deleteAgendamento(HttpServletRequest req) {
		AgendamentoModel agendamento = new AgendamentoModel();
		agendamento.setSchedulingID(Integer.parseInt(req.getAttribute("id").toString()));
		
		try {
			dao.delete(agendamento);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}