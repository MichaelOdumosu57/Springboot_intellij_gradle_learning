package javaconceptsbyjay.com.youtube.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
@Table
@Entity
@Data
@NoArgsConstructor
@XmlRootElement

public class Singers {
    @Id
    @Column(length = 3)
    @SequenceGenerator(sequenceName = "singer_gen1",allocationSize = 20,initialValue = 100,name="gen1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
    private Integer singersPosition;
    @Column(length = 15)
    private String singersName;
    @Column(length = 15)
    private double singersRenumeration;
}
