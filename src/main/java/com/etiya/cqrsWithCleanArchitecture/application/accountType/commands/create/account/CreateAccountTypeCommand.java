package com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateAccountTypeCommand {//Request

    @TargetAggregateIdentifier
    private String accountTypeId;
    private String accountName;
    private String description;
    private String price;

}
