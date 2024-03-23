package com.haveaseat.repository;

import com.haveaseat.entity.Resstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantStatusRepository extends JpaRepository<Resstatus, Integer> {
}
