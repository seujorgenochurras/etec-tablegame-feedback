package io.github.seujorgenochurras.repository;

import io.github.seujorgenochurras.domain.board.BoardMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapRepository extends JpaRepository<BoardMap, Integer> {
}
