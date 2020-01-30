package com.borrowing.repositories;

import com.borrowing.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,String> {
}
