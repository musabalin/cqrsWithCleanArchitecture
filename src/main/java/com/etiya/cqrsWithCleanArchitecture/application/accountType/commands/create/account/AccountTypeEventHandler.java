package com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account;

import com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account.AccountTypeCreatedEvent;
import com.etiya.cqrsWithCleanArchitecture.domain.AccountType;
import com.etiya.cqrsWithCleanArchitecture.persistence.AccountTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeEventHandler {

    private AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @EventHandler
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
        if(accountTypeRepository.existsByAccountName(accountTypeCreatedEvent.getAccountName())) {
        throw new RuntimeException("Bu hesap var");
        }
        AccountType accountType = new AccountType();
        BeanUtils.copyProperties(accountTypeCreatedEvent, accountType);//Aynı isimleri mapler
        accountTypeRepository.save(accountType);
    }



}
