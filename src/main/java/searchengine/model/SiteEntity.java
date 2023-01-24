package searchengine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "site")
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED') NOT NULL")
    private StatusEnum status;

    @Column(name = "status_time", columnDefinition = "DATETIME NOT NULL")
    private LocalDateTime statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT")
    private String lastError;

    @Column(name = "url", columnDefinition = "VARCHAR(255) NOT NULL")
    private String url;

    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "site")
    private List<PageEntity> pageEntity;

}
