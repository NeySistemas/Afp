package com.management.afp.repository;

import com.management.afp.model.Solicitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitationRepository extends JpaRepository<Solicitation,Long> {
}
