package miit.uvp.free.services.impl;

import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    private SchoolClassRepository schoolClassRepository;


}
