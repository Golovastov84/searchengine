package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import searchengine.model.SiteSql;

import java.util.List;

@Repository
public interface SiteSqlRepository extends JpaRepository<SiteSql, Integer> {

    @Query(value = "SELECT * from site where name LIKE %:namePart% LIMIT :limit", nativeQuery = true)
    List<SiteSql> findAllContains(String namePart, int limit);
}
