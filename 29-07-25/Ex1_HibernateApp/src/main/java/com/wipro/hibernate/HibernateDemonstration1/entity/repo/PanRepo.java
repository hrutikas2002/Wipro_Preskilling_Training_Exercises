package com.wipro.hibernate.HibernateDemonstration1.entity.repo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.hibernate.HibernateDemonstration1.entity.Pan;
import com.wipro.hibernate.HibernateDemonstration1.util.HibernateUtil;


public class PanRepo {
	public static void createPan() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PAN holder name:");
		String name = sc.next();
		System.out.println("Enter PAN number:");
		String number = sc.next();
		Pan pan = new Pan(name, number);
		save(pan);
	}

	public static void updatePan() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PAN ID to update:");
		int id = sc.nextInt();
		System.out.println("Enter new PAN holder name:");
		String name = sc.next();
		System.out.println("Enter new PAN number:");
		String number = sc.next();

		Pan pan = new Pan(name, number);
		save(pan);
	}

	// Insert or Update
	public static void save(Pan pan) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		if (pan.getId() != 0) {
			Pan existingPan = findById(pan.getId());
			if (existingPan != null) {
				existingPan.setPanholderName(pan.getPanholderName());
				existingPan.setPanNumber(pan.getPanNumber());
				session.persist(existingPan);
			}
		} else {
			session.persist(pan);
		}

		transaction.commit();
	}

	public static Pan findById(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Pan pan = session.find(Pan.class, id);
		transaction.commit();
		return pan;
	}

	public static Pan deleteById(int id) {
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
    	Transaction transaction=session.beginTransaction();
    	Pan pan=session.find(Pan.class, id);
    	session.remove(pan);
    	transaction.commit();
    	return pan;
	}

	public static List<Pan> findAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Pan> list = session.createQuery("from Pan", Pan.class).list();
		transaction.commit();
		return list;
	}

	public static List<String> findAllPanNumbers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<String> list = session.createQuery("SELECT panNumber from Pan", String.class).list();
		transaction.commit();
		return list;
	}

	public static List<Pan> findByHolderName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query<Pan> query = session.createQuery("from Pan where panholderName=:name", Pan.class);
		query.setParameter("name", name);
		List<Pan> list = query.list();
		transaction.commit();
		return list;
	}
}
