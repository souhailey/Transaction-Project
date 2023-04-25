package main;
import java.util.List;

public interface TransactionDao {
	int save(Transaction transaction) ;
	void begin();
	void flush();
	void commit();
	void delete(Transaction transaction);
	Transaction find(String ref);
	List<Transaction> GetAll();
}
