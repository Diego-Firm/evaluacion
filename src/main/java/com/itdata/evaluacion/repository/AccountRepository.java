package com.itdata.evaluacion.repository;


import com.itdata.evaluacion.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

}
