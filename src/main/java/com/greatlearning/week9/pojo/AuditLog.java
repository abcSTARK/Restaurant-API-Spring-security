package com.greatlearning.week9.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="auditlog")
public class AuditLog {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "date default sysdate")
    private Date creationDate;

    @Column
    private  String description;

    public AuditLog(String name) {
    }
}
