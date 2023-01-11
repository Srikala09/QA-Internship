package com.example.QAInternship.repository;

import com.example.QAInternship.model.Internship;
import com.example.QAInternship.model.Internshipmap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface InternshipmapRepository extends CrudRepository<Internshipmap,Integer> {
    Internshipmap save(Internshipmap internshipmap);

    Internshipmap findById(Integer id);


    Internshipmap findInternshipmapById(Integer id);
}
