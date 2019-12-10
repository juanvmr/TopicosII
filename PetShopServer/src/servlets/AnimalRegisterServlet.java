package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimalDao;
import dao.ConnectionFactory;
import models.AnimalModel;

@WebServlet("/animal")
public class AnimalRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static int quantidadeAnimal = 0;
	Connection connection = ConnectionFactory.getConnection("localhost", "4000", "PetShopServer", "admin", "admin");
	AnimalDao dao = new AnimalDao(connection);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getServletPath()) {
			case "/animal/create":
				createAnimal(req);
				break;
			case "/animal/update":
				updateAnimal(req);
				break;
			default: resp.sendError(404);
		}
		resp.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void createAnimal(HttpServletRequest req) {
		AnimalModel animal = new AnimalModel();
		animal.setNome(req.getAttribute("nome").toString());
		animal.setRaca(req.getAttribute("raca").toString());
		//animal.setId(quantidadeAnimal);
		animal.setSexo(req.getAttribute("sexo").toString());
		animal.setAltura(req.getAttribute("altura").toString());
		animal.setCor(req.getAttribute("cor").toString());
		animal.setPeso(req.getAttribute("peso").toString());
		animal.setIdade(req.getAttribute("idade").toString());

		try {
			dao.insert(animal);
			//quantidadeAnimal++;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	private void updateAnimal(HttpServletRequest req) {
		AnimalModel animal = new AnimalModel();
		animal.setNome(req.getAttribute("nome").toString());
		animal.setRaca(req.getAttribute("raca").toString());
		//animal.setId(quantidadeAnimal);
		animal.setSexo(req.getAttribute("sexo").toString());
		animal.setAltura(req.getAttribute("altura").toString());
		animal.setCor(req.getAttribute("cor").toString());
		animal.setPeso(req.getAttribute("peso").toString());
		animal.setIdade(req.getAttribute("idade").toString());
		
		try {
			dao.update(animal);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
