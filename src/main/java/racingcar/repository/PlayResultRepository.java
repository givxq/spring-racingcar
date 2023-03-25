package racingcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import racingcar.domain.PlayResult;

public interface PlayResultRepository extends JpaRepository<PlayResult, Long> {
    PlayResult save(PlayResult playResult);

    Optional<PlayResult> findById(Long id);

    Optional<PlayResult> findTopById(Long id);

    List<PlayResult> findAll();

    // @Query("SELECT distinct p FROM PlayResult p join fetch p.id")
    // public List<PlayResult> findAllWithCarUsingFetchJoin();
}
