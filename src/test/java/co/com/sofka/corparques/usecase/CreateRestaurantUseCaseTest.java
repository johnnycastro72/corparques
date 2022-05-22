package co.com.sofka.corparques.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.corparques.domain.generic.values.Name;
import co.com.sofka.corparques.domain.restaurant.commands.CreateRestaurant;
import co.com.sofka.corparques.domain.restaurant.events.RestaurantCreated;
import co.com.sofka.corparques.domain.restaurant.values.Location;
import co.com.sofka.corparques.domain.restaurant.values.RestaurantId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateRestaurantUseCaseTest {

    private CreateRestaurantUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CreateRestaurantUseCase();
    }

    @Test
    public void createRestaurantHappyPass() {
        // Arrange
        RestaurantId restaurantId = RestaurantId.of("xxxxx");
        Name name = new Name("Perros y Hamburguesas");
        Location location = new Location("Vertical Swing");
        var command = new CreateRestaurant(restaurantId, name, location);

        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert
        var restaurantCreated = (RestaurantCreated) events.get(0);

        Assertions.assertEquals("xxxxx", restaurantCreated.aggregateRootId());
        Assertions.assertEquals("Perros y Hamburguesas", restaurantCreated.name().value());
        Assertions.assertEquals("Vertical Swing", restaurantCreated.location().value());

    }
}