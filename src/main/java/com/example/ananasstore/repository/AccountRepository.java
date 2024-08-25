package com.example.ananasstore.repository;

import com.example.ananasstore.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    //find all account
    @Query(value = "SELECT a.*, g.gender_name, r.role_name " +
            "FROM account a" +
            " inner join role r" +
            "ON r.role_id = a.role_id" +
            "inner join gender g" +
            "ON g.gender_id = a.gender_id",
            nativeQuery = true)
    List<AccountEntity> findAllAccount(Pageable pageable, Sort sort);

    //add acount
    void insertAccountEntity(AccountEntity accountEntity);
}
