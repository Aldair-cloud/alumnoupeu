package pe.edu.upeu.alumno.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.alumno.dao.datosDao;
import pe.edu.upeu.alumno.dao.escuelaDao;
import pe.edu.upeu.alumno.daoImp.datosDaoImp;
import pe.edu.upeu.alumno.daoImp.escuelaDaoImp;
import pe.edu.upeu.alumno.entity.datos;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/ac")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
    datosDao datosdao = new datosDaoImp();
    escuelaDao escueladao = new escuelaDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//int iddatos = Integer.parseInt(request.getParameter("iddatos"));
		//int idescuela = Integer.parseInt(request.getParameter("idescuela"));
		String apell_nom = request.getParameter("apell_nom");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String nombreescuela = request.getParameter("nombreescuela");
		out.println(datosdao.create(new datos(0, 0, apell_nom, correo, telefono, nombreescuela)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
