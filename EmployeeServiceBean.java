package com.project.hr.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.project.hr.entity.Employee;
import com.project.hr.util.UtilityJPA;

/**
 * Session Bean implementation class EmployeeServiceBean
 */
@Stateless
@LocalBean
public class EmployeeServiceBean {
	
	@PersistenceContext(unitName = "HR_SYSTEM")
    private javax.persistence.EntityManager em = UtilityJPA.getEntityManager();
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
    public List<Employee>findAllEmployees() throws Exception {
    	TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
    	List<Employee>listEmployee = query.getResultList();
        return listEmployee;
    }

}
