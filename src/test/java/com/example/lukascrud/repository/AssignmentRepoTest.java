package com.example.lukascrud.repository;

import com.example.lukascrud.model.Assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentRepoTest {

    @Autowired
    AssignmentRepo assignmentRepo;

    @Test
    public void testExistsFetchAssignmentById() {
        Assignment assignment = assignmentRepo.fetchAssignmentById(1);

        assertNotNull(assignment);
        assertTrue(assignment.getId() > 0);

    }

    @Test
    public void testIdFetchAssignmentById() {
        Assignment assignment = assignmentRepo.fetchAssignmentById(1);

        assertEquals(1, assignment.getId());
    }

    @Test
    public void testNameFetchAssignmentById() {
        Assignment assignment = assignmentRepo.fetchAssignmentById(1);

        assertEquals("Web Server", assignment.getName());
    }

    @Test
    public void testDescFetchAssignmentById() {
        Assignment assignment = assignmentRepo.fetchAssignmentById(1);

        assertEquals("Create Web Server", assignment.getDescription());
    }
}