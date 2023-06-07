package edu.formation.todo.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/vueTODO.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		if (action.equals("ajouter")) {

			if (session.getAttribute("listeTodo") == null) {

				var listeTodo = new ArrayList<String>();

				listeTodo.add(request.getParameter("tache"));

				session.setAttribute("listeTodo", listeTodo);

			} else {
				ArrayList<String> listeTodo = (ArrayList<String>) (session.getAttribute("listeTodo"));
				listeTodo.add(request.getParameter("tache"));
			}

			if (action.equals("modifier")) {
				ArrayList<String> listeTodo = (ArrayList<String>) (session.getAttribute("listeTodo"));
				int indice = Integer.parseInt(request.getParameter("indice"));
				String tache = request.getParameter("tache");
				listeTodo.set(indice, tache);
			}

		}
		if (action.equals("supprimer")) {
			ArrayList<String> listeTodo = (ArrayList<String>) (session.getAttribute("listeTodo"));
			int indice = Integer.parseInt(request.getParameter("indice"));
			listeTodo.remove(indice);
		}

		ArrayList<String> listeTodo = (ArrayList<String>) (session.getAttribute("listeTodo"));

		request.setAttribute("listeTodo", listeTodo);
		request.getRequestDispatcher("WEB-INF/vueTODO.jsp").forward(request, response);
	}

}
