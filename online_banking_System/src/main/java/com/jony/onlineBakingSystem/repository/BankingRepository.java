package com.jony.onlineBakingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jony.onlineBakingSystem.request.BankingModel;

@Repository
public interface BankingRepository extends JpaRepository<BankingModel, Integer>{

	@Query("SELECT e FROM BankingModel e WHERE e.email = :email")
	BankingModel checkEmail(String email);

}
