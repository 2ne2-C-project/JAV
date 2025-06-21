package Junpyo_Growing.C.controller;


import Junpyo_Growing.C.entity.GameSession;
import Junpyo_Growing.C.entity.Item;
import Junpyo_Growing.C.entity.Upgrade;
import Junpyo_Growing.C.repository.GameSessionRepository;
import Junpyo_Growing.C.dto.GameSessionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameSessionRepository repository;

    public GameController(GameSessionRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/{UUid}")
    public ResponseEntity<GameSession> getOrCreate(@PathVariable String UUid) {
        GameSession session = repository.findById(UUid)
        .orElseGet(() -> {
            GameSession newSession = new GameSession();
            newSession.setUUid(UUid);
            newSession.setExp(0);
            String Basic = null;
            newSession.setMajor(Basic);
            newSession.setLastUpdated(LocalDateTime.now());
            return repository.save(newSession);
        });
        return ResponseEntity.ok(session);
    }

    @PostMapping("/{UUid}")
    public ResponseEntity<Void> update(@PathVariable String UUid, @RequestBody GameSessionDto dto) {
        GameSession session = repository.findById(UUid).orElseThrow();

        session.setExp(dto.exp);
        session.setLevel(dto.level);
        session.setMajor(dto.major);
        session.setOwnedItems(dto.ownedItems);
        session.setLastUpdated(LocalDateTime.now());

        repository.save(session);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{UUid}/buy")
    public ResponseEntity<String> buyItem(@PathVariable String UUid, @RequestBody Item item) {
        GameSession session = repository.findById(UUid).orElseThrow();
        if (session.getOwnedItems().contains(item.getItem_name())) {
            return ResponseEntity.status(409).body("이미 구매한 아이템입니다.");
        }

        if (session.getExp() >= item.getPrice()) {
            session.setExp(session.getExp() - item.getPrice());

            // 아이템 이름 추가
            session.getOwnedItems().add(item.getItem_name());

            repository.save(session);
            return ResponseEntity.ok("아이템 구매 성공!");
        }

        return ResponseEntity.status(400).body("경험치가 부족합니다.");
    }

    @PostMapping("/{UUid}/upgrade")
    public ResponseEntity<String> applyUpgrade(@PathVariable String UUid, @RequestBody Upgrade upgrade) {
        GameSession session = (GameSession) repository.findById(UUid).orElseThrow();

        if (upgrade.getEffect().equals("IQ+5")) {
            session.setIQ(session.getIQ() + 5);
        }

        repository.save(session);
        return ResponseEntity.ok("업그레이드 적용 완료");
    }

    @PostMapping("/{UUid}/update")
    public ResponseEntity<GameSession> updateFromC(@PathVariable String UUid, @RequestBody GameSessionDto dto) {
        GameSession session = repository.findById(UUid)
                .orElseGet(() -> {
                    GameSession newSession = new GameSession();
                    newSession.setUUid(UUid);
                    newSession.setExp(0);
                    newSession.setLevel(1);
                    newSession.setMajor(null);
                    newSession.setIQ(100); // 기본값 설정
                    newSession.setLastUpdated(LocalDateTime.now());
                    return repository.save(newSession);
                });
        return ResponseEntity.ok(session);
    }


}
