package com.example.lukascrud.repository;

import com.example.lukascrud.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentRepo {

    @Autowired
    JdbcTemplate template;

    public void createAssignment(Assignment assignment) {
        String sql = "INSERT INTO Assignment (name, description) VALUES(?,?)";
        template.update(sql, assignment.getName(), assignment.getDescription());
    }

    public List<Assignment> fetchAll() {
        String sql = "SELECT * FROM Assignment";
        RowMapper<Assignment> rowMapper = new BeanPropertyRowMapper<>(Assignment.class);
        return template.query(sql, rowMapper);
    }

    public Assignment findAssignmentById(int id) {
        String sql = "SELECT * FROM assignment WHERE id = ?";
        RowMapper<Assignment> rowMapper = new BeanPropertyRowMapper<>(Assignment.class);
        Assignment assignment = template.queryForObject(sql, rowMapper, id);
        return assignment;
    }

    public Boolean deleteAssignment(int id) {
        String sql = "DELETE FROM Assignment WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public void updateAssignment(int id, Assignment assignment) {
        String sql = "UPDATE Assignment SET name=?, description=? WHERE id=?";
        template.update(sql, assignment.getName(), assignment.getDescription(), id);
    }


}
