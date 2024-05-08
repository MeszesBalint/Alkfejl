// RunnerRepository.java

package com.example.futoverseny_2.repository;

import com.example.futoverseny_2.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long> {
}