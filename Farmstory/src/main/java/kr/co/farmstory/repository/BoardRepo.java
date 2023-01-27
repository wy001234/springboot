package kr.co.farmstory.repository;

import kr.co.farmstory.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<BoardEntity, String> {
}
