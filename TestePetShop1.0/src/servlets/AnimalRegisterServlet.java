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

@WebServlet({"/animal", "/animal/create", "/animal/update", "/animal/delete"})
public class AnimalRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static int quantidadeAnimal = 0;
	Connection connection = ConnectionFactory.getConnection("PetShopServer", "admin", "admin");
	AnimalDao dao = new AnimalDao(connection);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		switch(req.getServletPath()) {
			case "/animal/create":
				createAnimal(req);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				break;
			case "/animal/update":
				updateAnimal(req);
				resp.sendRedirect("/");
				break;
			case "/animal/delete":
				deleteAnimal(req);
				resp.sendRedirect("/");
				break;
			case "/animal":
				req.getRequestDispatcher("animalRegister.jsp").forward(req, resp);
				//resp.sendRedirect("animalRegister.jsp");
				break;
			default: resp.sendError(404);
		}
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
	
	private void deleteAnimal(HttpServletRequest req) {
		AnimalModel animal = new AnimalModel();
		animal.setId(Integer.parseInt(req.getAttribute("nome").toString()));
		
		try {
			dao.delete(animal);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
