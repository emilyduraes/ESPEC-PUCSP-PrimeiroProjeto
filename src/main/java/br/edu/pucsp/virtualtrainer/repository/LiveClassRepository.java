package br.edu.pucsp.virtualtrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.pucsp.virtualtrainer.model.entity.LiveClass;

public interface LiveClassRepository extends JpaRepository<LiveClass, Long> {


}