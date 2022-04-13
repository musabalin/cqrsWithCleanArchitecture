package com.etiya.cqrsWithCleanArchitecture.persistence;

import com.etiya.cqrsWithCleanArchitecture.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, String> {

    Boolean existsByAccountName(String accountName);
}
