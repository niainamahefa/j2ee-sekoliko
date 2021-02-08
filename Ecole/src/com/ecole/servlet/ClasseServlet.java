package com.ecole.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecole.dao.ClasseDao;
import com.ecole.dao.MatiereDao;
import com.ecole.model.Classe;

/**
 * Servlet implementation class ClasseServlet
 */
@WebServlet("/ClasseServlet")
public class ClasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClasseDao classeDao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()  throws ServletException {
    	classeDao = new ClasseDao();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				String action = request.getServletPath();
				
				switch (action) {
				case "/nouveau_classe":
					showAddForm(request, response);
					break;

				case "/inserer_classe":
					try {
						insertClasse(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case "/editer_classe":
					showEditForm(request, response);
					break;

				case "/supprimer_classe":
					try {
						deleteClasse(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case "/modifier_classe":
					try {
						updateClasse(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					default:
						listClasse(request, response);
						break;
					
				}
	}
	
	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 request.getRequestDispatcher("/WEB-INF/classe-form.jsp").forward(request, response);
	}
	
	// INSERT MATIERE
	private void insertClasse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException 
	{
		String cls_nom = request.getParameter("cls_nom");
		Classe classe = new Classe(cls_nom);
		classeDao.insertClasse(classe);
		response.sendRedirect("classe");
		
	}
	
	// DELETE MATIERE
	private void deleteClasse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int cls_id = Integer.parseInt(request.getParameter("cls_id"));
		
		try {
			classeDao.deleteClasse(cls_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		response.sendRedirect("classe");
	}
	
	// EDIT MATIERE
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, ServletException, IOException 
	{
		
		int cls_id = Integer.parseInt(request.getParameter("cls_id"));
		
		Classe existingClasse;
		
		try {
			existingClasse = classeDao.selectClasse(cls_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/classe-edit-form.jsp");
			request.setAttribute("classe", existingClasse);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// UPDATE 
	private void updateClasse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException
	{
		int cls_id = Integer.parseInt(request.getParameter("cls_id"));
		String cls_nom = request.getParameter("cls_nom");
		
		Classe classe = new Classe(cls_id, cls_nom);
		classeDao.updateClasse(classe);
		response.sendRedirect("classe");
		
	}
	
	//DEFAULT 
	private void listClasse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, ServletException, IOException {
		
		try {
			List<Classe> listClasse = classeDao.selectAllClasse();
			request.setAttribute("listClasse", listClasse);
			request.getRequestDispatcher("/WEB-INF/classe.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	

}
