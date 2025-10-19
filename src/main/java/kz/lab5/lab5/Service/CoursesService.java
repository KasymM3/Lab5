package kz.lab5.lab5.Service;

import kz.lab5.lab5.Entity.Courses;
import kz.lab5.lab5.Repository.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService {

    private final CoursesRepository coursesRepository;

    public List<Courses> findAll(){
        return coursesRepository.findAll();
    }
}
