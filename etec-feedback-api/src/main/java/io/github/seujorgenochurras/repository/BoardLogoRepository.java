package io.github.seujorgenochurras.repository;

import io.github.seujorgenochurras.domain.board.BoardLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardLogoRepository extends JpaRepository<BoardLogo, Integer> {

}
