package com.example.ananasstore.repository;

import com.example.ananasstore.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    //find all account
//    @Query(value = "SELECT a.*, g.gender_name, r.role_name " +
//            "FROM account a" +
//            " inner join role r" +
//            "ON r.role_id = a.role_id" +
//            "inner join gender g" +
//            "ON g.gender_id = a.gender_id",
//            nativeQuery = true)
//    Page<AccountEntity> findAllAccount(Pageable pageable);
    @Query(value = "Select * from account", nativeQuery = true)
    Page<AccountEntity> getAllAccount(Pageable pageable);

    //getAccount By userName
    Optional<AccountEntity> getAccountByUserName(String userName);
}
