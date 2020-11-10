package com.hemlata.app.repository;
import com.hemlata.app.model.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepo extends CrudRepository<Expenses, Integer>{
	@Query(value="SELECT * from Expenses where logged=:logger",nativeQuery=true)
	public Iterable<Expenses> xpensesbylogin(long logger);
	@Query("SELECT SUM(amount) FROM Expenses")
	public int amountsum();
	@Query(value="SELECT Distinct category from Expenses where logged=:logger order by category ASC ",nativeQuery=true)
	public String[] cats(long logger);
	@Query(value="SELECT SUM(amount) from Expenses where logged=:logger group by category order by category ASC",nativeQuery=true)
	public int[] catWiseamts(long logger);
	@Query(value="SELECT SUM(amount) from Expenses where logged=:logger group by category order by category ASC",nativeQuery=true)
	public int[] month(long logger);
	@Query(value="SELECT SUM(amount) from Expenses where logged=:logger group by MONTH(billdate)",nativeQuery=true)
	public int[] monthWiseTotal(long logger);
	@Query(value="SELECT MONTH(billdate) from Expenses where logged=:logger group by MONTH(billdate)",nativeQuery=true)
	public String[] GetMonths(long logger);
	@Query(value="SELECT SUM(amount) from Expenses where logged=:logger group by YEAR(billdate)",nativeQuery=true)
	public int[] yearWiseTotal(long logger);
	@Query(value="SELECT YEAR(billdate) from Expenses where logged=:logger group by YEAR(billdate)",nativeQuery=true)
	public String[] Getyears(long logger);
	@Query(value="select SUM(amount) from Expenses WHERE billdate BETWEEN CURDATE()-7 AND CURDATE() group by billdate order by billdate ASC",nativeQuery=true)
	public int[] getWeeklyTotal();
	@Query(value="select billdate from Expenses WHERE billdate BETWEEN CURDATE()-7 AND CURDATE()  group by billdate order by billdate ASC",nativeQuery=true)
	public String[] getWeekDates();

}
