package ss16.service;

import ss16.entity.Spend;

import java.util.Collection;
import java.util.Map;

public interface ISpend {
    Spend addSpend(Spend spend);
    void delete(int code);
    void update(int code, Spend spend);
    Collection<Spend> getAll();
    Spend searchByCode(int code);
    Map<Integer, Spend> searchByName(String name);
    Boolean isCodeExist(int code);
<<<<<<< HEAD
=======
    void findAll();
>>>>>>> save-detached-work
}
