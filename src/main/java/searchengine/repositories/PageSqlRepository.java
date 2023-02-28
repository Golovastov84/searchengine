package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import searchengine.model.PageSql;

import java.util.List;

@Repository
public interface PageSqlRepository extends JpaRepository<PageSql,Integer> {
    @Query(value = "SELECT * from page where path LIKE %:pagePart% LIMIT :limit", nativeQuery = true)
    List<PageSql> findAllContains(String pagePart, int limit);
}
