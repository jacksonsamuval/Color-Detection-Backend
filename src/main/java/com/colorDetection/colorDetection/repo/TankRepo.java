package com.colorDetection.colorDetection.repo;

import com.colorDetection.colorDetection.model.Tanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TankRepo extends JpaRepository<Tanks, Integer> {
    Optional<Tanks> findByTankName(String tankName);
    @Query("SELECT t FROM Tanks t WHERE TRIM(LOWER(t.tankName)) = LOWER(:tankName)")
    Optional<Tanks> findByTankNameIgnoreCaseTrim(@Param("tankName") String tankName);


}
