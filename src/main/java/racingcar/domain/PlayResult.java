package racingcar.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(name = "PLAY_RESULT_SEQ_GENERATOR", sequenceName = "PLAY_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "PLAY_RESULT", uniqueConstraints = {
        @UniqueConstraint(name = "ID_UNIQUE", columnNames = { "ID" })
})
public class PlayResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAY_RESULT_SEQ_GENERATOR")
    @Column(name = "id")
    private long id;

    @Column(name = "WINNERS", nullable = false, length = 100)
    private String winners;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "playResult", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Car> cars = new ArrayList<>();

    public void setWinners(String winners) {
        this.winners = winners;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Builder
    public PlayResult(String winners) {
        this.winners = winners;
    }
}
