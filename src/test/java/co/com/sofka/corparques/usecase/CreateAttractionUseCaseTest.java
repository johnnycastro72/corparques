package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.attraction.commands.CreateAttraction;
import co.com.sofka.corparques.domain.attraction.values.*;
import co.com.sofka.corparques.domain.generic.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CreateAttractionUseCaseTest {

    private CreateAttractionUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CreateAttractionUseCase();
    }

    @Test
    public void createAttractionHappyPass() {
        //Arrange
        AttractionId attractionId = AttractionId.of("xxxxx");
        Name name = new Name("Aviones");
        Capacity capacity = new Capacity(20);
        MinimumHeight minimumHeight = new MinimumHeight(90D);
        OperatorId operatorId = OperatorId.of("yyyyy");
        CashierId cashierId = CashierId.of("zzzzz");

        var command = new CreateAttraction(attractionId, name, capacity, minimumHeight, operatorId, cashierId);

        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var attractionCreated = (co.com.sofka.corparques.domain.attraction.events.AttractionCreated) events.get(0);

        Assertions.assertEquals("xxxxx", attractionCreated.aggregateRootId());
        Assertions.assertEquals("Aviones", attractionCreated.name().value());
        Assertions.assertEquals(20, attractionCreated.capacity().value());
        Assertions.assertEquals(90D, attractionCreated.minimumHeight().value());
        Assertions.assertEquals("yyyyy", attractionCreated.operatorId().value());
        Assertions.assertEquals("zzzzz", attractionCreated.cashierId().value());

    }
}