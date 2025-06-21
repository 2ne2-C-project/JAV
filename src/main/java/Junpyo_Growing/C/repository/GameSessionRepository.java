package Junpyo_Growing.C.repository;

import Junpyo_Growing.C.entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, String> {
}
