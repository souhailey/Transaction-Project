package main;
import java.util.List;

import com.mysql.cj.Query;

import jakarta.persistence.EntityManager;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;




public class TransactionDaoImpl implements TransactionDao {
	private EntityManagerFactory ef = Persistence.createEntityManagerFactory("JPA");
	public EntityManager em=ef.createEntityManager();
	
	@Override
	public void begin() {
		em.getTransaction().begin();
	}
	@Override
	public void flush() {
		em.flush();
	}
	@Override
	public void commit() {
		em.getTransaction().commit();
	}
	@Override
	public int save(Transaction transaction) {
		int error = 0;
		em.persist(transaction);
			error++;
		System.out.println("The transaction was added");
		return error;
	}
	@Override
	public void delete(Transaction transaction) {
		em.remove(transaction);
	}
	@Override
	public Transaction find(String ref) {
		return em.find(Transaction.class, ref);
	}
	@Override
	public List<Transaction> GetAll() {
		TypedQuery<Transaction> query =  em.createQuery("select t from Transaction t", Transaction.class);
		List<Transaction> TransactionList = query.getResultList();
		return TransactionList;
	}

}
