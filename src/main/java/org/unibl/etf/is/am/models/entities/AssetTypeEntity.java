package org.unibl.etf.is.am.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.unibl.etf.is.am.base.BaseEntity;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "asset_type")
@EntityListeners(AuditingEntityListener.class)
public class AssetTypeEntity implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 120)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @OneToMany(mappedBy = "assetType")
    @JsonIgnore
    private List<AssetEntity> assets;
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private Date createdAt;
    @Column(name = "updated_at")
    @LastModifiedDate
    private Date modifiedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    @JoinColumn(name = "created_by", referencedColumnName = "id", updatable = false)
    private UserEntity createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private UserEntity updatedBy;
}
