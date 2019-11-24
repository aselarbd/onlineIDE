package com.aselad.ide.postgresapp.Repository;

import com.aselad.ide.postgresapp.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project findByProjectId(long id);
}
