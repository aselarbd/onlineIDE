package com.aselad.ide.postgresapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Project database entity class
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PROJECTS")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_scope", nullable = false)
    private String projectScope;

    @Column(name = "project_owner", nullable = false)
    private String projectOwner;

    @Column(name = "project_organization", nullable = false)
    private String projectOrganization;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getProjectId() {
        return projectId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectScope() {
        return projectScope;
    }

    public void setProjectScope(String projectScope) {
        this.projectScope = projectScope;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public String getProjectOrganization() {
        return projectOrganization;
    }

    public void setProjectOrganization(String projectOrganization) {
        this.projectOrganization = projectOrganization;
    }
}
