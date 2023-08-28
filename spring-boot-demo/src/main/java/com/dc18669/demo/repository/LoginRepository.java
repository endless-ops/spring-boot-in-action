package com.dc18669.demo.repository;

import com.dc18669.demo.model.Password;
import com.dc18669.demo.model.Teacher;
import com.dc18669.demo.model.oto.TeacherToPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Teacher,Long> {

    @Query(value = "select new com.dc18669.demo.model.oto.TeacherToPassword(t, p) from Teacher t, Password p where t.name = :name and t.id = p.teacher.id")
    TeacherToPassword findByName (@Param("name") String name);

}
