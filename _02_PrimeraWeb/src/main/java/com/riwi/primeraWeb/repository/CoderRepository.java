package com.riwi.primeraWeb.repository;

import com.riwi.primeraWeb.entity.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderRepository extends JpaRepository<Coder, Long>{



}
