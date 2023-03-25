package racingcar.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// @Entity
// @Getter
// @EntityListeners(AuditingEntityListener.class)
// @SequenceGenerator(name = "PLAY_RESULT_SEQ_GENERATOR", sequenceName = "PLAY_SEQ", initialValue = 1, allocationSize = 1)
// @Table(name = "Cars", uniqueConstraints = {
//         @UniqueConstraint(name = "ID_NAME_UNIQUE", columnNames = { "ID", "NAME" })
// })
public class PlayHistory {
    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "PLAY_RESULT_SEQ_GENERATOR")
    private long id;

    private String name;

    private int position;

    // @CreatedDate
    // @LastModifiedDate
    private LocalDateTime createAt;

    public PlayHistory() {
    }

    public PlayHistory(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        if (CarRandom.isMove())
            moveForward();
    }

    public void moveForward() {
        position++;
    }

}
