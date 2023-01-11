package com.example.QAInternship.service;

import com.example.QAInternship.model.Internship;
import com.example.QAInternship.model.Internshipmap;
import com.example.QAInternship.repository.InternshipmapRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.QAInternship.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import  org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InternshipmapService {
    @Autowired
    InternshipmapRepository internshipmapRepository;
    private final String  from = "baddechandu999@gmail.com" ;

    public List<Internshipmap> fetchAllInternshipmaps(){
        List<Internshipmap> internshipmapList = (List<Internshipmap>)internshipmapRepository.findAll();
        return internshipmapList;
    }
    public boolean  sendMail(String toMail){
        boolean sentSts =  true ;
        try {
            MailUtil.sendMail(from, toMail, "testing", "welcome to QT..");

        }catch(Exception e) {
            e.printStackTrace();
            sentSts = false ;
        }
        return sentSts;
    }
    public Internshipmap createInternshipmap(Internshipmap internshipmap)
    {
        return  internshipmapRepository.save(internshipmap);

    }
    public Internshipmap fetchInternshipmapById(Integer id){
        return internshipmapRepository.findInternshipmapById(id);

    }
    public void  persistInternshipmap(Internshipmap internshipmap) {
        internshipmapRepository.save(internshipmap);

    }
    public void  modifyInternshipmap(Internshipmap internshipmap) {

        internshipmapRepository.save(internshipmap);

    }}