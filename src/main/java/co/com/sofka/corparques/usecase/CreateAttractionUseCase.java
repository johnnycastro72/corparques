package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.CreateAttraction;

public class CreateAttractionUseCase extends UseCase<RequestCommand<CreateAttraction>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateAttraction> createAttractionRequestCommand) {
        var command = createAttractionRequestCommand.getCommand();

        var attraction = new Attraction(command.attractionId(),
                command.name(),
                command.capacity(),
                command.minimumHeight(),
                command.operatorId(),
                command.cashierId());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
