package com.hemlata.app.repository;
import com.hemlata.app.model.Balance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends CrudRepository<Balance, Integer>{
	@Query(value="select sum(bal) from Balance where ballog=:logger",nativeQuery=true)
	public int Balsum(Long logger);
}
