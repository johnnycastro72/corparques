package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.ChangeOperatorClothes;

public class ChangeOperatorClothesUseCase extends UseCase<RequestCommand<ChangeOperatorClothes>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeOperatorClothes> changeOperatorClothesRequestCommand) {
        var command = changeOperatorClothesRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.ChangeOperatorClothes(command.attractionId(), command.operatorId(), command.clothes());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
