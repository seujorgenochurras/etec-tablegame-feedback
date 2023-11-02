package io.github.seujorgenochurras.repository;

import io.github.seujorgenochurras.domain.board.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {
}
