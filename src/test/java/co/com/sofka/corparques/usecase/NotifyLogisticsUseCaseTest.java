package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.events.LogisticsNotified;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.Message;
import co.com.sofka.corparques.domain.generic.values.Name;
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
class NotifyLogisticsUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private NotifyLogisticsUseCase useCase;

    @Test
    void notifyLogisticsHappyPass() {
        // Arrange
        AttractionId attractionId = AttractionId.of("xxxxx");
        Name name = new Name("Vertical Swing");
        Capacity capacity = new Capacity(30);
        MinimumHeight minimumHeight = new MinimumHeight(110D);
        OperatorId operatorId = OperatorId.of("yyyyy");
        CashierId cashierId = CashierId.of("zzzzz");
        var event = new AttractionCreated(attractionId, name, capacity, minimumHeight, operatorId, cashierId);

        when(repository.getEventsBy(event.attractionId().value())).thenReturn(List.of(event));
        useCase.addRepository(repository);
        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.attractionId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var eventResponse = (LogisticsNotified)events.get(0);
        Assertions.assertEquals("The attraction has been created and is available, please play it throughout the park.", eventResponse.message().value());
        Mockito.verify(repository).getEventsBy(event.attractionId().value());
    }

}