package case_study.controller;

import case_study.entity.RealEstate;
import case_study.service.RealEstateService;

public class RealEstateController {
    RealEstateService service = new RealEstateService();
    public void add(RealEstate realEstate){
        service.add(realEstate);
    }
    public void findAll(){
        service.findAll();
    }
    public void delete(int code){
        service.delete(code);
    }

}
