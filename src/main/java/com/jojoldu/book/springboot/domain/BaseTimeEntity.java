package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// Auditing function include
@EntityListeners(AuditingEntityListener.class)

public abstract class BaseTimeEntity {
    // time auto save
    @CreatedDate
    private LocalDateTime createDate;
    // select Entity value change -> time auto save
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
