package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Teacher;
import entities.Teacher;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class TeacherService
 */
@Stateless
@LocalBean
public class TeacherService {

	@PersistenceContext(unitName="tp3jee") 
	private EntityManager em; 
	
    /**
     * Default constructor. 
     */
    public TeacherService() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Teacher> getAllTeachers(){ 
    	List<Teacher> teachers = new ArrayList<Teacher>(); 
    	TypedQuery<Teacher> query = 
    	em.createNamedQuery("Teacher.findAll",Teacher.class); 
    	teachers = query.getResultList(); 
    	return teachers;
    }  

}
