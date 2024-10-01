package com.example.ananasstore.repository;

import com.example.ananasstore.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
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

    //find account by Id
    @Query(value = "select " +
            "a.account_id," +
            "a.password," +
            "a.email," +
            "a.user_name," +
            "a.address," +
            "a.phone_number," +
            "a.date_of_birth, " +
            "a.gender_id, " +
            "a.role_id" +
            " from account a " +
            "where a.account_id = :id", nativeQuery = true)
    AccountEntity getAccountById(int id);

}
