package com.etiya.cqrsWithCleanArchitecture.ws.controllers;

import com.etiya.cqrsWithCleanArchitecture.application.accountType.commands.create.account.CreateAccountTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateAccountTypeModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/accounttypes")
public class AccountTypeController {

    private CommandGateway commandGateway;

    public AccountTypeController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateAccountTypeModel createAccountTypeModel){
        CreateAccountTypeCommand command=CreateAccountTypeCommand.builder()
                .price(createAccountTypeModel.getPrice())
                .accountName(createAccountTypeModel.getAccountName())
                .description(createAccountTypeModel.getDescription())
                .build();
        command.setAccountTypeId(UUID.randomUUID().toString());

        this.commandGateway.sendAndWait(command);

    }
}
