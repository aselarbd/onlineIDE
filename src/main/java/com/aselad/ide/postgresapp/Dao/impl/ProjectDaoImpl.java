package com.aselad.ide.postgresapp.Dao.impl;

import com.aselad.ide.postgresapp.Dao.ProjectDao;
import com.aselad.ide.postgresapp.Entity.Project;
import com.aselad.ide.postgresapp.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Collection<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(Long id) {
        return projectRepository.findByProjectId(id);
    }

    @Override
    public Project createProject(Project project) {
        projectRepository.save(project);
        return projectRepository.findByProjectId(project.getProjectId());
    }

    @Override
    public void updateProject(Project project) {

        projectRepository.findById(project.getProjectId()).map(
                projectToUpdate -> {
                    projectToUpdate.setProjectName(project.getProjectName());
                    projectToUpdate.setProjectOrganization(project.getProjectOrganization());
                    projectToUpdate.setProjectOwner(project.getProjectOwner());
                    projectToUpdate.setProjectScope(project.getProjectScope());
                    return projectRepository.save(projectToUpdate);
                }
        );
    }

    @Override
    public Optional<ResponseEntity<Object>> deleteProject(long id) {
         return projectRepository.findById(id).map(
                project ->{
                    projectRepository.delete(project);
                    return ResponseEntity.ok().build();
                }
        );
    }
}
