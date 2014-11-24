package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;

import java.util.ArrayList;
import java.util.List;

public abstract class CarolRepository {
    private List<Carol> carols = new ArrayList<Carol>();

    public List<Carol> getCarols() {
        return carols;
    }

    public abstract void loadCarols();

    protected void addCarol(Carol carol) {
        carols.add(carol);
    }

    protected boolean removeCarol(Carol carol) {
        return carols.remove(carol);
    }
}
