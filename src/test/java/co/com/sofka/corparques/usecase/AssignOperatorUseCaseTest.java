package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.attraction.commands.AssignCashier;
import co.com.sofka.corparques.domain.attraction.commands.AssignOperator;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.events.CashierAssigned;
import co.com.sofka.corparques.domain.attraction.events.OperatorAssigned;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssignOperatorUseCaseTest {
    @InjectMocks
    private AssignOperatorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void AssignOperatorHappyPass() {
        // Arrange
        AttractionId attractionId = AttractionId.of("sssss");
        OperatorId operatorId = OperatorId.of("ddddd");
        var command = new AssignOperator(attractionId, operatorId);

        when(repository.getEventsBy("sssss")).thenReturn(history());
        useCase.addRepository(repository);

        // Act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.attractionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (OperatorAssigned)events.get(0);
        Assertions.assertEquals("sssss", event.aggregateRootId());
        Assertions.assertEquals("ddddd", event.operatorId().value());
        Mockito.verify(repository).getEventsBy(command.attractionId().value());
    }

    private List<DomainEvent> history() {
        AttractionId attractionId = AttractionId.of("sssss");
        Name name = new Name("Aviones");
        Capacity capacity = new Capacity(20);
        MinimumHeight minimumHeight = new MinimumHeight(90D);
        OperatorId operatorId = OperatorId.of("yyyyy");
        CashierId cashierId = CashierId.of("zzzzz");

        var event = new AttractionCreated(attractionId, name, capacity, minimumHeight, operatorId, cashierId);

        event.setAggregateRootId("sssss");

        return List.of(event);
    }

}