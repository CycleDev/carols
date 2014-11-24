package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;

import java.util.List;

public class CarolMemoryRepository extends CarolRepository {

    @Override
    public void loadCarols() {

        addCarol(new Carol(1, "Carol 1", "Carol text 1", "Carol info 1"));
        addCarol(new Carol(2, "Carol 2", "Carol text 2", "Carol info 2"));
        addCarol(new Carol(3, "Carol 3", "Carol text 3", "Carol info 3"));
        addCarol(new Carol(4, "Carol 4", "Carol text 4", "Carol info 4"));
        addCarol(new Carol(5, "Carol 5", "Carol text 5", "Carol info 5"));
        addCarol(new Carol(6, "Carol 6", "Carol text 6", "Carol info 6"));

    }
}
