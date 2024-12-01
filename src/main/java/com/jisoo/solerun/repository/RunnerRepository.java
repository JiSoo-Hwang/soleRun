package com.jisoo.solerun.repository;

import com.jisoo.solerun.entity.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<Runner,Long> {

}
