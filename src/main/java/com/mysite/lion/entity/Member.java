package com.mysite.lion.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.*;

@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_id", nullable=false)
    private String id;

    @Column(name = "member_password12", nullable = false)
    private String password;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_phone", nullable = false)
    private String phone;

}
