package com.example.lukascrud.service;

import com.example.lukascrud.model.Assignment;
import com.example.lukascrud.repository.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepo assignmentRepo;

    public void createAssignment(Assignment assignment) {
        assignmentRepo.createAssignment(assignment);
    }

    public List<Assignment> fetchAll() {
        return assignmentRepo.fetchAll();
    }

    public Assignment findAssignmentById(int id) {
        return assignmentRepo.findAssignmentById(id);
    }

    public Boolean deleteAssignment(int id) {
        try {
            return assignmentRepo.deleteAssignment(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public void updateAssignment(int id, Assignment assignment) {
        assignmentRepo.updateAssignment(id, assignment);
    }


}
