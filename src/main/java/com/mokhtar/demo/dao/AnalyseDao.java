package com.mokhtar.demo.dao;

import com.mokhtar.demo.entity.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseDao extends JpaRepository<Analyse,Long> {
}
