package com.management.afp.repository;

import com.management.afp.model.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfpRepository extends JpaRepository<Afp,Long> {
}
