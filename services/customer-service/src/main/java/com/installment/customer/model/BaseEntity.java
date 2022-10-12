package com.installment.customer.model;


import lombok.Data;
import org.springframework.boot.actuate.audit.listener.AuditListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners({AuditListener.class})
@Data
public abstract class BaseEntity {

    @Id
    @Column(name = "ID", length = 60)
    private String id;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "LAST_UPDATE_DATE")
    private LocalDateTime lastUpdateDate;

    @Column(name = "CREATE_OPERATOR_NAME")
    private String createOperatorName;

    @Column(name = "UPDATE_OPERATOR_NAME")
    private String updateOperatorName;

    public BaseEntity() {
        setId(UUID.randomUUID().toString());
    }

    public BaseEntity(String id) {
        this.id = id;
    }


}
