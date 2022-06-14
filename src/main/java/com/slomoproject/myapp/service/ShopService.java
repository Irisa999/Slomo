package com.slomoproject.myapp.service;

import com.slomoproject.myapp.domain.Shop;
import com.slomoproject.myapp.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ShopService {
    @Autowired
    ShopRepository shopRepository;


    public Shop createShop(Shop shopDTO){
       return shopRepository.save(shopDTO);
    }
    public void deleteShop(String id){
        shopRepository.deleteById(Long.valueOf(id));
    }
    public List<Shop> findByCity(String c){
        return shopRepository.findShopsByCity(c);
    }
    public Shop findById(String id){
        return shopRepository.getById(Long.valueOf(id));
    }
    public Shop updateShop(String id,Shop bo){
       Long shopTBC = shopRepository.getById(Long.valueOf(id)).getId();
       bo.setId(shopTBC);
       return shopRepository.save(bo);
    }
    public void validate(String shopId){
        Shop shopRepositoryById = shopRepository.getById(Long.valueOf(shopId));
        if(shopRepositoryById.getValidated()){
           shopRepositoryById.setValidated(false);
        }else{
            shopRepositoryById.setValidated(true);
        }
        shopRepository.save(shopRepositoryById);
    }


}
