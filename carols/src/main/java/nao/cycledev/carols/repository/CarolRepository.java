package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;

import java.util.List;

public interface CarolRepository {

    List<Carol> getAll();
}
