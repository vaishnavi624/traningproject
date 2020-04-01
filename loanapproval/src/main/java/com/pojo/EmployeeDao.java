package com.pojo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {

	private Configuration conf;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	
	@SuppressWarnings("deprecation")
	public void saveData(Customer e) {
		
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
	}

		@SuppressWarnings({ "deprecation", "rawtypes" })
	public List login(String email, String pass) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		String sql="from Customer  as e where e.cemail=? and e.cpass=?";
		Query query1= session.createQuery(sql);
		query1.setParameter(0, email);
		query1.setParameter(1, pass);
		List list = query1.list();
		return list;
	}

	@SuppressWarnings("deprecation")
	public List displayData() {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Customer").list();
		return list;
	}
	}
