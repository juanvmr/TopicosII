package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import dao.AgendamentoDao;
import dao.AnimalDao;
import dao.ClienteDao;
import dao.ConnectionFactory;
import models.*;

@WebServlet("/datasummary")
public class DataSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = ConnectionFactory.getConnection("localhost", "4000", "PetShopServer", "admin", "admin");
	AgendamentoDao agendamentoDao = new AgendamentoDao(connection);
	ClienteDao clienteDao = new ClienteDao(connection);
	AnimalDao animalDao = new AnimalDao(connection);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("dataSummary.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void deleteCliente(HttpServletRequest req) {
		ClienteModel cliente = new ClienteModel();
		cliente.setId(Integer.parseInt(req.getAttribute("id").toString()));
		
		try {
			clienteDao.delete(cliente);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteAgendamento(HttpServletRequest req) {
		AgendamentoModel agendamento = new AgendamentoModel();
		agendamento.setSchedulingID(Integer.parseInt(req.getAttribute("id").toString()));
		
		try {
			agendamentoDao.delete(agendamento);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteAnimal(HttpServletRequest req) {
		AnimalModel animal = new AnimalModel();
		animal.setId(Integer.parseInt(req.getAttribute("id").toString()));
		
		try {
			animalDao.delete(animal);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}


	private void getData(HttpServletRequest req) {
		try {
			List<Object> listAgendamento = agendamentoDao.select();
			List<Object> listCliente = clienteDao.select();
			List<Object> listAnimal = animalDao.select();
			req.setAttribute("listAgendamento", listAgendamento);
			req.setAttribute("listCliente", listCliente);
			req.setAttribute("listAnimal", listAnimal);
		}
        catch(SQLException e) {
        	e.printStackTrace();
        }
	}
}