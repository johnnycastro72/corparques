package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.attraction.commands.AddAttractionCustomer;
import co.com.sofka.corparques.domain.attraction.events.AttractionCreated;
import co.com.sofka.corparques.domain.attraction.events.AttractionCustomerAdded;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.CustomerId;
import co.com.sofka.corparques.domain.generic.values.Email;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.generic.values.Phone;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddAttractionCustomerUseCaseTest {

    @InjectMocks
    private AddAttractionCustomerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAnAttractionHappyPass() {
        // Arrange
        AttractionId attractionId = AttractionId.of("ddddd");
        CustomerId customerId = CustomerId.of("xxxxx");
        Name name = new Name("Santiago Posada");
        Email email = new Email("santiago.posada@sofka.com.co");
        Phone phone = new Phone("3333334444");
        BirthDate birthDate = new BirthDate(LocalDateTime.of(1995, 04, 25, 6, 15));
        Height height = new Height(180D);
        IsPassportUser isPassportUser = new IsPassportUser(false);
        var command = new AddAttractionCustomer(attractionId, customerId, name, email, phone, birthDate, height, isPassportUser);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        // Act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.attractionId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var event = (AttractionCustomerAdded)events.get(0);
        Assertions.assertEquals("ddddd",event.aggregateRootId());
        Assertions.assertEquals("xxxxx",event.customerId().value());
        Assertions.assertEquals("Santiago Posada",event.name().value());
        Assertions.assertEquals("santiago.posada@sofka.com.co",event.email().value());
        Assertions.assertEquals("3333334444",event.phone().value());
        Assertions.assertEquals(LocalDateTime.of(1995, 04, 25, 6, 15),event.birthDate().value());
        Assertions.assertEquals(180D,event.height().value());
        Assertions.assertEquals(false,event.isPassportUser().value());

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