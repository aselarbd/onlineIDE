package com.aselad.ide.postgresapp.Dao;

import com.aselad.ide.postgresapp.Entity.Project;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Optional;


public interface ProjectDao {

    public Collection<Project> getAllProjects ();

    public Project getProject(Long id);

    public Project createProject(Project project);

    public void updateProject(Project project);

    public Optional<ResponseEntity<Object>> deleteProject(long id);
}
