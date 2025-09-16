package com.colorDetection.colorDetection.repo;

import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.model.Tanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorsRepo extends JpaRepository<Colors,Integer> {
    List<Colors> findByTank(Optional<Tanks> tanks);
}
