package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateAttractionCustomerHeight;

public class UpdateAttractionCustomerHeightUseCase extends UseCase<RequestCommand<UpdateAttractionCustomerHeight>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateAttractionCustomerHeight> updateAttractionCustomerHeightRequestCommand) {
        var command = updateAttractionCustomerHeightRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateAttractionCustomerHeight(command.attractionId(), command.customerId(), command.height());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
