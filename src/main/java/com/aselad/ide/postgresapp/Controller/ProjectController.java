package com.aselad.ide.postgresapp.Controller;

import com.aselad.ide.postgresapp.Constants;
import com.aselad.ide.postgresapp.Dao.ProjectDAO;
import com.aselad.ide.postgresapp.Entity.Project;
import com.aselad.ide.postgresapp.Result.ResponseWrapper;
import com.aselad.ide.postgresapp.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import static com.aselad.ide.postgresapp.Constants.MESSAGE_FOR_REGEX_NUMBER_MISMATCH;
import static com.aselad.ide.postgresapp.Constants.REGEX_FOR_NUMBERS;

@Validated
@RestController
@RequestMapping("/"+Constants.API+"/"+Constants.VERSION+"/"+Constants.PROJECT_API)
public class ProjectController {


    private ProjectService projectService;

    @GetMapping(value = "/{id}")
    public ResponseWrapper<Project> getProjectById(@Valid @Pattern(regexp = REGEX_FOR_NUMBERS,
            message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id ){

        return new ResponseWrapper<>( projectService.getProjectById(Long.parseLong( id )), HttpStatus.OK );
    }

    @GetMapping()
    public ResponseWrapper<Page<Project>> getProjectAll(Pageable pageable ) {
        return new ResponseWrapper<>( projectService.getAllProjects( pageable ), HttpStatus.OK );
    }

    @PostMapping
    public ResponseWrapper<Project> createProject( @Valid @RequestBody Project project ) {
        return new ResponseWrapper<>( projectService.addNewProject(project), HttpStatus.OK );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseWrapper<Project> deleteProject(
            @Valid @Pattern(regexp = REGEX_FOR_NUMBERS,
                    message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id ) {
        return new ResponseWrapper<>( projectService.deleteProject(Long.parseLong(id)), HttpStatus.OK );
    }

    @PatchMapping(value = "/{id}")
    public ResponseWrapper<Project> UpdateProject( @Valid @RequestBody Project project,
                                                   @Valid @Pattern(regexp = REGEX_FOR_NUMBERS,
            message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id ) {
        return new ResponseWrapper<>( projectService.updateProject( project, Long.parseLong( id ) ), HttpStatus.OK );
    }
}
