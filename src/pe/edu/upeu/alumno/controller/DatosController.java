package pe.edu.upeu.alumno.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import pe.edu.upeu.alumno.entity.escuela;

/**
 * Servlet implementation class DatosController
 */
@WebServlet("/dd")
public class DatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Gson gson = new Gson();
    datosDao datosdao = new datosDaoImp();
    escuelaDao escueladao = new escuelaDaoImp();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("op"));
		switch (op) {
		case 1:
			datos dato = datosdao.finds(Integer.parseInt(request.getParameter("iddatos")));
			out.println(gson.toJson(dato));
			break;
		case 2:
			List<datos> datos = datosdao.read();
			out.println(gson.toJson(datos));
			break;
		/*case 3:
			List<escuela> escuelas = escueladao.listarescuelas();
			out.println(gson.toJson(escuelas));
			break;*/
		case 3:
			datos dat = new datos(0, Integer.parseInt(request.getParameter("idescuela")), request.getParameter("nombreescuela"),request.getParameter("apell_nom"), request.getParameter("correo"), request.getParameter("telefono"));
			break;
		default:
			break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("op"));
		switch (op) {
		case 2:
			datos datt = new datos(0, Integer.parseInt(request.getParameter("idescuela")), request.getParameter("nombreescuela"), request.getParameter("apell_nom"), request.getParameter("correo"), request.getParameter("telefono"));
			out.println(gson.toJson(datosdao.update(datt)));
			break;
		case 3:
			int datto = datosdao.delete(Integer.parseInt(request.getParameter("iddatos")));
			out.println(gson.toJson(datto));
			break;

		default:
			break;
		}
	}

}
