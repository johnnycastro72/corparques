package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.attraction.commands.UpdateAttractionCustomerPhone;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.events.AttractionCustomerPhoneUpdated;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateAttractionCustomerPhoneUseCaseTest {
    @InjectMocks
    private UpdateAttractionCustomerPhoneUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateAttractionCustomerPhoneHappyPass() {
        // Arrange
        AttractionId attractionId = AttractionId.of("ddddd");
        CustomerId customerId = CustomerId.of("xxxxx");
        Phone phone = new Phone("3203213232");
        var command = new UpdateAttractionCustomerPhone(attractionId, customerId, phone);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        // Act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.attractionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (AttractionCustomerPhoneUpdated)events.get(0);
        Assertions.assertEquals("ddddd",event.aggregateRootId());
        Assertions.assertEquals("xxxxx",event.customerId().value());
        Assertions.assertEquals("3203213232",event.phone().value());
        Mockito.verify(repository).getEventsBy(command.attractionId().value());

    }

    private List<DomainEvent> history() {
        AttractionId attractionId = AttractionId.of("ddddd");
        Name name = new Name("Aviones");
        Capacity capacity = new Capacity(20);
        MinimumHeight minimumHeight = new MinimumHeight(90D);
        OperatorId operatorId = OperatorId.of("yyyyy");
        CashierId cashierId = CashierId.of("zzzzz");

        var event = new AttractionCreated(attractionId, name, capacity, minimumHeight, operatorId, cashierId);

        event.setAggregateRootId("ddddd");

        return List.of(event);
    }

}