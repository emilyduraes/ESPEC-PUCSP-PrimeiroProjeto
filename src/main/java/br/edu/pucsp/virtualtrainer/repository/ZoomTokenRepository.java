package br.edu.pucsp.virtualtrainer.repository;

import br.edu.pucsp.virtualtrainer.domain.entity.ZoomToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoomTokenRepository extends JpaRepository<ZoomToken, Long> {
}
