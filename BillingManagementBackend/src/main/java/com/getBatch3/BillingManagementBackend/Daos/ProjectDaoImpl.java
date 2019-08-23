package com.getBatch3.BillingManagementBackend.Daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.getBatch3.BillingManagementBackend.models.Project;
import com.getBatch3.BillingManagementBackend.models.ProjectConfiguration;


@Component
@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	
	
	public List<Project> getAllProject() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Project");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public Project getProjectById(String projectId)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Project c=session.get(Project.class, projectId);
			return c;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public boolean setProjectConfig(ProjectConfiguration obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<ProjectConfiguration> getAllProjectConfig() {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectConfiguration");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
