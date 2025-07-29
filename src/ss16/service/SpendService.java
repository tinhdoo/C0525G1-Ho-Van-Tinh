package ss16.service;

import ss16.entity.Spend;
import ss16.repository.SpendRepo;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public class SpendService implements ISpend {
    private SpendRepo repo = new SpendRepo();

    @Override
    public Spend addSpend(Spend spend) {
        repo.add(spend);
        return spend;
    }

    @Override
    public void delete(int code) {
        repo.delete(code);
    }

    @Override
    public void update(int code, Spend spend) {
        repo.update(code, spend);
    }

    @Override
    public Collection<Spend> getAll() {
        return repo.getAll();
    }

    @Override
    public Spend searchByCode(int code) {
        return repo.searchByCode(code);
    }

    @Override
    public Map<Integer, Spend> searchByName(String name) {
        return repo.searchByName(name);
    }

    @Override
    public Boolean isCodeExist(int code) {
        return repo.isCodeExist(code);
    }

    @Override
    public void findAll() {
        repo.findAll();
    }


    public List<Spend> sortByNameAsc() {
        return repo.sortByNameAsc();
    }
    public List<Spend> sortByAmountDescThenNameAsc() {
        return repo.sortByAmountDescThenNameAsc();
    }
}
//code như quần què
// xoá mịa