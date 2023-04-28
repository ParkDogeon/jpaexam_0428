package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Member extends BaseEntity{
    @Id @GeneratedValue
    private Long userNo;

    @Column(length = 40, unique = true, nullable = false)
    private String userId;

    @Column(length = 65, nullable = false)
    private String userPw;

    @Column(length = 40, nullable = false)
    private String userNm;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) // 연관관계의 주인을 명시(외래키가 관계주인)
    private List<BoardData> boardDatas = new ArrayList<>();

    /*@ManyToOne
    @JoinColumn(name = "managerNo")
    private Member manager;*/

    @OneToOne
    @JoinColumn(name = "addressId")
    @ToString.Exclude
    private Address address;

}
