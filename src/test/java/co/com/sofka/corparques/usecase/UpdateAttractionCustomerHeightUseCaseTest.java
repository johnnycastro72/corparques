package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.attraction.commands.ChangeAttractionPassportUser;
import co.com.sofka.corparques.domain.attraction.commands.UpdateAttractionCustomerHeight;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.events.AttractionCustomerHeightUpdated;
import co.com.sofka.corparques.domain.attraction.events.AttractionPassportUserChanged;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateAttractionCustomerHeightUseCaseTest {
    @InjectMocks
    private UpdateAttractionCustomerHeightUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateAttractionCustomerHeightHappyPass() {
        // Arrange
        AttractionId attractionId = AttractionId.of("ddddd");
        CustomerId customerId = CustomerId.of("xxxxx");
        Height height = new Height(182D);
        var command = new UpdateAttractionCustomerHeight(attractionId, customerId, height);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        // Act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.attractionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (AttractionCustomerHeightUpdated)events.get(0);
        Assertions.assertEquals("ddddd",event.aggregateRootId());
        Assertions.assertEquals("xxxxx",event.customerId().value());
        Assertions.assertEquals(182D,event.height().value());

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