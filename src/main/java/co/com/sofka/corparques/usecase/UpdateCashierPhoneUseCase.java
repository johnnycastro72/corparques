package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.corparques.domain.attraction.Attraction;
import co.com.sofka.corparques.domain.attraction.commands.UpdateCashierEmail;
import co.com.sofka.corparques.domain.attraction.commands.UpdateCashierPhone;

public class UpdateCashierPhoneUseCase extends UseCase<RequestCommand<UpdateCashierPhone>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCashierPhone> updateCashierPhoneRequestCommand) {
        var command = updateCashierPhoneRequestCommand.getCommand();
        var attraction = Attraction.from(command.attractionId(), repository().getEventsBy(command.attractionId().value()));
        attraction.UpdateCashierPhone(command.attractionId(), command.cashierId(), command.phone());

        emit().onResponse(new ResponseEvents(attraction.getUncommittedChanges()));
    }
}
