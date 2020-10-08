package com.example.lukascrud.controller;

import com.example.lukascrud.model.Assignment;
import com.example.lukascrud.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/crud")
    //@PreAuthorize("hasRole('USER')")
    public String crud(Model model) {
        List<Assignment> assignmentList = assignmentService.fetchAll();
        model.addAttribute("assignments", assignmentList);
        return "crud";
    }

    @PostMapping("/crud")
    //@PreAuthorize("hasRole('USER')")
    public String crud(@ModelAttribute Assignment assignment, Model model) {
        assignmentService.createAssignment(assignment);
        List<Assignment> assignmentList = assignmentService.fetchAll();
        model.addAttribute("assignments", assignmentList);
        return "crud";
    }

    @GetMapping("/deleteassignment/{id}")
    //@PreAuthorize("hasRole('USER')")
    public String deleteAssignment(@PathVariable("id") int id) {
        assignmentService.deleteAssignment(id);
        return "redirect:/crud";
    }

    @GetMapping("/updateassignment/{id}")
    //@PreAuthorize("hasRole('USER')")
    public String updateAssignment(@PathVariable("id") int id, Model model) {
        model.addAttribute("assignment", assignmentService.fetchAssignmentById(id));
        return "updateassignment";
    }

    @PostMapping("/crud/updateassignment")
    //@PreAuthorize("hasRole('USER')")
    public String updateAssignment(@ModelAttribute Assignment assignment) {
        assignmentService.updateAssignment(assignment.getId(), assignment);
        return "redirect:/crud";
    }


}
