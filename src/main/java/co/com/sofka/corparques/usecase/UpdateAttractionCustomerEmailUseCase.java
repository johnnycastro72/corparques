package co.com.sofka.corparques.usecase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateAttractionCustomerEmail;

public class UpdateAttractionCustomerEmailUseCase extends UseCase<RequestCommand<UpdateAttractionCustomerEmail>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAttractionCustomerEmail> updateAttractionCustomerEmailRequestCommand) {
        var command = updateAttractionCustomerEmailRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateAttractionCustomerEmail(command.attractionId(), command.customerId(), command.email());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
