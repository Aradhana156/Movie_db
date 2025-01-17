package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Moviedao;
import dto.Movie;

@WebServlet("/fetch-movies")
public class FechMovie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Moviedao dao=new Moviedao();
		List<Movie> list=dao.fetchmovies();
		if(list.isEmpty())
		{
			resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Add""</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}
		else
		{
			resp.getWriter().print("<true>");
			resp.getWriter().print("<th> Name</th>");
		}
	}
}
