package searchengine.model;

import javax.persistence.*;

@Entity
@Table(name = "page")
public class PageSQL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private int id;

    @Column(name = "site_id", columnDefinition = "INT")
//    надо добавить связь с site
    private int siteId;

    @Column(columnDefinition = "TEXT")
    private String path;

    @Column(columnDefinition = "INT")
    private int code;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;

    public PageSQL() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
