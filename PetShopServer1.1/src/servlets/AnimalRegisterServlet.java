package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AnimalModel;

@WebServlet("/AnimalRegister")
public class AnimalRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int quantidadeAnimal = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("animal"+quantidadeAnimal, createAnimal(request.getAttribute("nome").toString(), request.getAttribute("raca").toString(), request.getAttribute("sexo").toString(), request.getAttribute("cor").toString(), request.getAttribute("idade").toString(), request.getAttribute("altura").toString(), request.getAttribute("peso").toString()));
		quantidadeAnimal++;
		response.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private AnimalModel createAnimal(String nome, String raca, String sexo, String cor, String idade, String altura, String peso) {
		AnimalModel animal = new AnimalModel();
		animal.setAltura(altura);
		animal.setCor(cor);
		animal.setId(quantidadeAnimal);
		animal.setIdade(idade);
		animal.setNome(nome);
		animal.setPeso(peso);
		animal.setRaca(raca);
		animal.setSexo(sexo);
		return animal;
	}

}
