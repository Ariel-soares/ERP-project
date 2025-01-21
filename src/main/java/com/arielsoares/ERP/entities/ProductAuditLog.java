package com.arielsoares.ERP.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public class ProductAuditLog extends BaseEntity{

    private Long productId;
    private LocalDateTime changedAt;
    private String changedBy;
    private HashMap<String, String> changes = new HashMap<>();
    private String type;

    public ProductAuditLog() {}

    public ProductAuditLog(Long productId, LocalDateTime changedAt, String changedBy, String type) {
        this.productId = productId;
        this.changedAt = changedAt;
        this.changedBy = changedBy;
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public HashMap<String, String> getChanges() {
        return changes;
    }

    public void setChanges(HashMap<String, String> changes) {
        this.changes = changes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductAuditLog that = (ProductAuditLog) o;
        return Objects.equals(productId, that.productId) && Objects.equals(changedAt, that.changedAt) && Objects.equals(changedBy, that.changedBy) && Objects.equals(changes, that.changes) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productId, changedAt, changedBy, changes, type);
    }
}
