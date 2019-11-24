package com.aselad.ide.postgresapp.Dao.impl;

import com.aselad.ide.postgresapp.Dao.ProjectDAO;
import com.aselad.ide.postgresapp.Entity.Project;
import com.aselad.ide.postgresapp.Exception.ResourceNotFoundException;
import com.aselad.ide.postgresapp.Repository.ProjectRepository;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PostgreSQLDAOImpl extends ProjectDAO {

    private final Logger LOGGER = LogManager.getLogger(PostgreSQLDAOImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Page<Project> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project add(Project o) {
        return projectRepository.save(o);
    }

    @Override
    public Project update(Project o, long id) {
        Project project = checkProjectExist(id);
        project.setProjectName(o.getProjectName());
        project.setProjectScope(o.getProjectScope());
        project.setProjectOwner(o.getProjectOwner());
        project.setProjectOrganization(o.getProjectOrganization());
        project.setUpdatedAt(o.getUpdatedAt());
        return projectRepository.save(project);
    }

    @Override
    public Project getById(long id) {
        return checkProjectExist(id);
    }

    @Override
    public Project deleteById(long id) {
        Project project = checkProjectExist(id);
        projectRepository.deleteById(id);
        return project;
    }

    private Project checkProjectExist(long id) {
        if (projectRepository.findById(id).isEmpty()){
            String MSG = "Project ID :"+id+" Not found";
            LOGGER.debug(MSG);
            try {
                throw new ResourceNotFoundException(MSG);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }

        }
        return projectRepository.findById(id).get();
    }
}
