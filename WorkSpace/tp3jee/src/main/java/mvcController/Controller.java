package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcModel.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.*;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB 
	private SubjectService subjectService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Subject> s = new ArrayList<Subject>(); 
		s = subjectService.getAllSubjects(); 
		for(Subject sub : s) 
		response.getWriter().append(sub.getSubjectTitle() + "").append(sub.getTeacher().getFirstName() + " " + sub.getTeacher().getName() + "\n"); 
		
		
		
		String btnValue = request.getParameter("myBtn");
		
		if (btnValue != null && btnValue.equals("Rechercher Matieres")){
			String intitule = request.getParameter("intitule"); 
			String affiliation = request.getParameter("affiliation");
			List<Subject> subjects = new ArrayList<Subject>(); 
			subjects = subjectService.getAllSubjectsByTitleAndAffiliation(intitule, affiliation);
			for(Subject sub : subjects) 
			response.getWriter().append(sub.getSubjectTitle() + " \n");
			
		}
		
		else { 
		String actionValue = request.getParameter("action"); 
			if (actionValue != null && actionValue.contentEquals("listSubjects")) { 
			 List<Subject> subjects1 = new ArrayList<Subject>(); 
			 subjects1 = subjectService.getAllSubjects(); 
			 request.setAttribute("subjects", subjects1); 
			 for (Subject sub : subjects1) 
			  response.getWriter().append(sub.getSubjectTitle() + "").append(sub.getTeacher().getFirstName() + " " + sub.getTeacher().getName() + "\n"); 
			} 
		}

		
		
		
		

		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
