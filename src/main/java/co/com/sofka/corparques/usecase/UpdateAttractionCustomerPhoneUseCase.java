package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateAttractionCustomerPhone;

public class UpdateAttractionCustomerPhoneUseCase extends UseCase<RequestCommand<UpdateAttractionCustomerPhone>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAttractionCustomerPhone> updateAttractionCustomerPhoneRequestCommand) {
        var command = updateAttractionCustomerPhoneRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateAttractionCustomerPhone(command.attractionId(), command.customerId(), command.phone());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
