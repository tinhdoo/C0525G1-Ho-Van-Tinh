package case_study.service;

import case_study.entity.RealEstate;
import case_study.repository.RealEstateRepository;

public class RealEstateService implements comparable<RealEstate> {
    RealEstateRepository repository = new RealEstateRepository();
    @Override
    public void add(RealEstate realEstate) {
        repository.add(realEstate);
    }


    @Override
    public void delete(int code) {
        repository.delete(code);
    }

    @Override
    public void update() {

    }

    @Override
    public void findAll() {
        repository.findAll();
    }
    public void contact() {

    }
}
