package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import searchengine.model.Lemma;

import java.util.List;

@Repository
public interface LemmaRepository extends JpaRepository<Lemma, Integer> {
    @Query(value = "SELECT * from lemma where lemma LIKE %:lemmaPart% LIMIT :limit", nativeQuery = true)
    List<Lemma> findAllContains(String lemmaPart, int limit);
}
