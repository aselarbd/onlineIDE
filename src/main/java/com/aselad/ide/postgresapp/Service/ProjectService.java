package com.aselad.ide.postgresapp.Service;


import com.aselad.ide.postgresapp.Dao.ProjectDAO;
import com.aselad.ide.postgresapp.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * All the business logic goes here
 *
 */
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    public Project getProjectById (Long projectId) {
        // All business logic goes here

        return projectDAO.getById(projectId);
    }

    public Page<Project> getAllProjects(Pageable pageable) {
        // All business logic goes here

        return projectDAO.getAll(pageable);
    }

    public Project addNewProject(Project project){
        // All business logic goes here

        return projectDAO.add(project);
    }

    public Project deleteProject(Long projectId){
        // All business logic goes here

        return projectDAO.deleteById(projectId);
    }

    public Project updateProject(Project project, Long projectId){
        // All business logic goes here

        return projectDAO.update(project,projectId);
    }

}
