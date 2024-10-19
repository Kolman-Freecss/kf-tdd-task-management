package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kolmanfreecss.kftddtaskmanagement.application.services.ProjectService;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.ProjectController;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Test class for the ProjectController.
 * Java implementation.
 *
 * @author Kolman-Freecss
 * @version 1.0
 * @see ProjectController
 */
@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for creating a project.
     */
    @Test
    void testCreateProject() throws Exception {
        final ProjectDto project = new ProjectDto(
                1,
                "Project 1",
                "Description of project 1",
                new Date(),
                new Date(),
                null);

        // When: The project is saved by the service
        when(projectService.createProject(any(ProjectDto.class))).thenReturn(project);

        // Then: Perform POST request and verify the response
        mockMvc.perform(post("/api/v1/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Project created successfully"))
                .andExpect(jsonPath("$.dtoData.name").value("Project 1"))
                .andExpect(jsonPath("$.dtoData.description").value("Description of project 1"))
                .andExpect(jsonPath("$.dtoData.startDate").isNotEmpty())
                .andExpect(jsonPath("$.dtoData.endDate").isNotEmpty());
    }

}
