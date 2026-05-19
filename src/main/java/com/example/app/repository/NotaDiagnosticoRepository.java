package com.example.app.repository;

import com.example.app.model.NotaDiagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaDiagnosticoRepository extends JpaRepository<NotaDiagnostico, Long> {
}
