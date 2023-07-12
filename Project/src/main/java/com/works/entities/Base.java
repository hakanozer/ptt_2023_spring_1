package com.works.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.TimeZone;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class Base {

    @CreatedBy
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @JsonFormat( pattern = "HH:mm:ss dd-MM-yyyy", timezone = "Europe/Istanbul")
    private Date createdDate;

    @LastModifiedBy
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @JsonFormat( pattern = "HH:mm:ss dd-MM-yyyy", timezone = "Europe/Istanbul")
    private Date lastModifiedDate;

    private Boolean status;

}
