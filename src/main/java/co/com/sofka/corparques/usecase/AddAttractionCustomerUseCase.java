package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.AddAttractionCustomer;

public class AddAttractionCustomerUseCase extends UseCase<RequestCommand<AddAttractionCustomer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAttractionCustomer> addAttractionCustomerRequestCommand) {
        var command = addAttractionCustomerRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.AddAttractionCustomer(command.attractionId(), command.customerId(), command.name(), command.email(), command.phone(), command.birthDate(), command.height(), command.isPassportUser());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
