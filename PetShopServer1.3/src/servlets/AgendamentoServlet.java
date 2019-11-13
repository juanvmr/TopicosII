package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AgendamentoModel;

@WebServlet("/Register/Agendamento")
public class AgendamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int quantidadeAgendamento = 0;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("agendamento"+quantidadeAgendamento, createAgendamento(req));
		quantidadeAgendamento++;
		resp.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private AgendamentoModel createAgendamento(HttpServletRequest req) {
		AgendamentoModel agendamento = new AgendamentoModel();
		agendamento.setAnimal(req.getAttribute("animal").toString());
		agendamento.setDate(req.getAttribute("data").toString());
		agendamento.setSchedulingID(quantidadeAgendamento);
		agendamento.setService(req.getAttribute("servico").toString());
		
		return agendamento;
	}

}