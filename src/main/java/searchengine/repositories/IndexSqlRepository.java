package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import searchengine.model.IndexSql;

import java.util.List;

@Repository
public interface IndexSqlRepository extends JpaRepository<IndexSql, Integer> {
    @Query(value = "SELECT * from index where id LIKE %:indexPart% LIMIT :limit", nativeQuery = true)
    List<IndexSql> findAllContains(String indexPart, int limit);
}
