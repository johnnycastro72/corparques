package co.com.sofka.corparques.domain.restaurant;

import co.com.sofka.corparques.domain.restaurant.values.Color;
import co.com.sofka.corparques.domain.restaurant.values.NumberOfChairs;
import co.com.sofka.corparques.domain.restaurant.values.TableId;
import co.com.sofka.domain.generic.Entity;


public class Table extends Entity<TableId> {
    private Color color;
    private NumberOfChairs numberOfChairs;

    public Table(TableId tableId) {
        super(tableId);
    }

    public Table(TableId tableId, Color color, NumberOfChairs numberOfChairs) {
        super(tableId);
        this.color = color;
        this.numberOfChairs = numberOfChairs;
    }

    public void ChangeColor(Color color) {
        this.color = color;
    }

    public void ChangeNumberOfChairs(NumberOfChairs numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    public Color color() {
        return color;
    }

    public NumberOfChairs numberOfChairs() {
        return numberOfChairs;
    }
}
