package com.atabey.expence_tracker_app.repository;

import com.atabey.expence_tracker_app.model.Expence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence, Long> {


}
