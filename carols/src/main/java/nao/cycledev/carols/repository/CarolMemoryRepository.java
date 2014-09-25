package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;

import java.util.ArrayList;
import java.util.List;

public class CarolMemoryRepository implements CarolRepository {

    private List<Carol> carols;

    public CarolMemoryRepository() {
        carols = new ArrayList<Carol>();
        carols.add(new Carol(1, "Carol 1", "Carol text 1", "Carol info 1"));
        carols.add(new Carol(2, "Carol 2", "Carol text 2", "Carol info 2"));
        carols.add(new Carol(3, "Carol 3", "Carol text 3", "Carol info 3"));
        carols.add(new Carol(4, "Carol 4", "Carol text 4", "Carol info 4"));
        carols.add(new Carol(5, "Carol 5", "Carol text 5", "Carol info 5"));
    }

    @Override
    public List<Carol> getAll() {
        return carols;
    }
}
