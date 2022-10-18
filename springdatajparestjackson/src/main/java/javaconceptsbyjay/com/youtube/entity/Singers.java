package javaconceptsbyjay.com.youtube.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@NoArgsConstructor
public class Singers {
    @Id
    @Column(length = 3)
    @GeneratedValue
    private Integer singersPosition;
    @Column(length = 15)
    private String singersName;
    @Column(length = 15)
    private double singersRenumeration;
}
