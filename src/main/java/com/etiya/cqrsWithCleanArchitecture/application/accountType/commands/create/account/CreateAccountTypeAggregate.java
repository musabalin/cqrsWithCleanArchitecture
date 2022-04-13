package com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateAccountTypeAggregate {

    @AggregateIdentifier
    private String accountTypeId;
    private String accountName;
    private String description;
    private String price;

    @CommandHandler
    public CreateAccountTypeAggregate(CreateAccountTypeCommand command) {

        AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();
        BeanUtils.copyProperties(command, accountTypeCreatedEvent);
        AggregateLifecycle.apply(accountTypeCreatedEvent);
    }

    @EventSourcingHandler
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
        this.accountName = accountTypeCreatedEvent.getAccountName();
        this.accountTypeId = accountTypeCreatedEvent.getAccountTypeId();
        this.description = accountTypeCreatedEvent.getDescription();
        this.price = accountTypeCreatedEvent.getPrice();
    }


}
