package racingcar.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Cars")
@IdClass(CarID.class)
public class Car {
    // @Id
    // @JoinColumn(name = "id")
    // private long id;

    @Id
    private String name;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PlayResult playResult;

    private int position;

    @CreatedDate
    @LastModifiedDate
    private LocalDateTime createAt;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    // public void setId(long id) {
    // this.id = id;
    // }

    public void setPlayResult(PlayResult playResult) {
        this.playResult = playResult;
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
