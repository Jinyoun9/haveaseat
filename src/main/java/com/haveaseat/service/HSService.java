package com.haveaseat.service;

import com.haveaseat.entity.Restaurant;
import com.haveaseat.entity.Resstatus;
import com.haveaseat.repository.RestaurantRepository;
import com.haveaseat.repository.RestaurantStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HSService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantStatusRepository restaurantStatusRepository;
    public void write(Resstatus resstatus) {restaurantStatusRepository.save(resstatus);}
    public Resstatus rstatusView(int id){
        return restaurantStatusRepository.findById(id).get();
    }
    public List<Restaurant> restaurantList(){
        return restaurantRepository.findAll();
    }
    public List<Resstatus> restaurantstatusList(){return restaurantStatusRepository.findAll();}
}
