package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.ChangeAttractionPassportUser;

public class ChangeAttractionPassportUserUseCase extends UseCase<RequestCommand<ChangeAttractionPassportUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeAttractionPassportUser> changeAttractionPassportUserRequestCommand) {
        var command = changeAttractionPassportUserRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.ChangeAttractionPassportUser(command.attractionId(), command.customerId(), command.isPassportUser());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
