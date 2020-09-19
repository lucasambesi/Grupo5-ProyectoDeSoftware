package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao {
	protected static Session session;
	protected Transaction tx;
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error accediendo a los datos.", he);
	}
	
	public <E> int agregar(E objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch(HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return id;	
	}
	
	public <E> boolean actualizar(E objeto) throws HibernateException {
		boolean seActualizo = false;
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
			seActualizo = true;
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		
		return seActualizo;
	}
	
	public <E> boolean eliminar(E objeto) throws HibernateException {
		boolean seElimino = false;
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
			seElimino = true;
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		
		}
		
		return seElimino;
	}
}
