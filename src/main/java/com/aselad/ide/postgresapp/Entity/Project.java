package com.aselad.ide.postgresapp.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Project database entity class
 */

@Entity
@Table(name = "PROJECTS")
public class Project {

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

    public Project(int projectId, String projectName, String projectScope, String projectOwner, String projectOrganization, Date createdAt, Date updatedAt) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectScope = projectScope;
        this.projectOwner = projectOwner;
        this.projectOrganization = projectOrganization;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Project () {}

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
