package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.restaurant.events.LogisticsByRestaurantNotified;
import co.com.sofka.corparques.domain.restaurant.events.RestaurantCreated;
import co.com.sofka.corparques.domain.restaurant.values.Location;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
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
class RestaurantNotifyLogisticsUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private RestaurantNotifyLogisticsUseCase useCase;

    @Test
    void RestaurantNotifyLogisticsHappyPass() {
        // Arrange
        RestaurantId restaurantId = RestaurantId.of("xxxxx");
        Name name = new Name("Perros y Hamburguesas");
        Location location = new Location("Vertical Swing");
        var event = new RestaurantCreated(restaurantId, name, location);

        when(repository.getEventsBy(event.restaurantId().value())).thenReturn(List.of(event));
        useCase.addRepository(repository);
        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.restaurantId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var eventResponse = (LogisticsByRestaurantNotified)events.get(0);
        Assertions.assertEquals("The restaurant has been created and is available, please play it throughout the park.", eventResponse.message().value());
        Mockito.verify(repository).getEventsBy(event.restaurantId().value());
    }

}