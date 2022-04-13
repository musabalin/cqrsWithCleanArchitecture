package com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account;

import lombok.Data;

@Data
public class AccountTypeCreatedEvent {

    private String accountTypeId;
    private String accountName;
    private String description;
    private String price;

}
