package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.*;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class SubjectService
 */
@Stateless
@LocalBean
public class SubjectService {
	
	@PersistenceContext(unitName="tp3jee") 
	private EntityManager em; 

    /**
     * Default constructor. 
     */
    public SubjectService() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    public List<Subject> getAllSubjects(){ 
    	List<Subject> subjects = new ArrayList<Subject>(); 
    	TypedQuery<Subject> query = 
    	em.createNamedQuery("Subject.findAll",Subject.class); 
    	subjects = query.getResultList(); 
    	return subjects; 
    }  

}
