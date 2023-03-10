package searchengine.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "site")
@NoArgsConstructor
@Getter
@Setter
public class SiteSql {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT"/*, nullable = false, unique = true*/)
    /*@OneToMany(cascade = CascadeType.ALL)*/
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum", nullable = false)
    private SiteIndexingStatus status;

    @Column(name = "status_time", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT")
    private String lastError;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String url;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    /*public SiteSql() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SiteIndexingStatus getStatus() {
        return status;
    }

    public void setStatus(SiteIndexingStatus status) {
        this.status = status;
    }

    public LocalDateTime getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(LocalDateTime statusTime) {
        this.statusTime = statusTime;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
