package com.colorDetection.colorDetection.repo;

import com.colorDetection.colorDetection.model.OpenCvColor;
import com.colorDetection.colorDetection.model.Tanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpenCvColorRepo extends JpaRepository<OpenCvColor,Integer> {
    List<OpenCvColor> findByTank(Optional<Tanks> tanks);
}
