package com.example.QAInternship.controller;

import com.example.QAInternship.dto.InternshipDTO;
import com.example.QAInternship.dto.InternshipmapDTO;
import com.example.QAInternship.model.Internship;
import com.example.QAInternship.model.Internshipmap;
import com.example.QAInternship.repository.InternshipmapRepository;
import com.example.QAInternship.service.InternshipmapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InternshipmapController {
    @Autowired
    InternshipmapService internshipmapService;
    InternshipmapDTO internshipmapDTO;
    ModelMapper modelMapper = new ModelMapper() ;
    public InternshipmapController()
    {}
    @GetMapping(value = "/internshipmap/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<InternshipmapDTO> fetchAllInternshipmaps() {
        System.out.println("In controller...");
        List<Internshipmap> internshipmapList =  internshipmapService.fetchAllInternshipmaps();
        List<InternshipmapDTO> internshipmaps = Arrays.asList(modelMapper.map(internshipmapList,InternshipmapDTO[].class));
        return internshipmaps;
    }
    @GetMapping(value = "/internshipmap/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public InternshipmapDTO fetchInternshipmapById(@PathVariable("id") Integer id) {
        System.out.println("Fetching Internshipmaps by id ...");
        Internshipmap internshipmap =  internshipmapService.fetchInternshipmapById(id);
        InternshipmapDTO  internshipmapDTO = modelMapper.map(internshipmap,InternshipmapDTO.class);
        return internshipmapDTO ;
    }
    @PostMapping(value = "/internshipmap/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  createInternshipmap(@RequestBody InternshipmapDTO internshipmapDTO) {
        System.out.println("name of the Internshipmaps=="+internshipmapDTO.getProject_name());
        Internshipmap internshipmap = modelMapper.map(internshipmapDTO,Internshipmap.class);
        internshipmapService.createInternshipmap(internshipmap);
        internshipmapService.persistInternshipmap(internshipmap);
        return ResponseEntity.ok().body("Internshipmapping Details Registered Successfully.");
    }

    @PutMapping(value = "/internshipmap/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updateInternshipmap(@RequestBody InternshipmapDTO internshipmapDTO) {
        Internshipmap internshipmap  = internshipmapService.fetchInternshipmapById(internshipmapDTO.getId());
        internshipmapService.modifyInternshipmap(generateInternshipmap(internshipmapDTO,internshipmap));
        return ResponseEntity.ok().body("Internship Mapping Details Modified Successfully.");
    }
    private Internshipmap  generateInternshipmap(InternshipmapDTO internshipmapDTO,Internshipmap internshipmap) {

        internshipmap.setId(internshipmapDTO.getId());
        internshipmap.setProject_name(internshipmapDTO.getProject_name());
        internshipmap.setDomain(internshipmapDTO.getDomain());
        internshipmap.setType(internshipmapDTO.getType());
        internshipmap.setTesters(internshipmapDTO.getTesters());
        return internshipmap ;

    }

}
