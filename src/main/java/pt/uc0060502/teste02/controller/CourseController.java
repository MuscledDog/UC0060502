package pt.uc0060502.teste02.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import pt.uc0060502.teste02.model.Course;
import pt.uc0060502.teste02.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController // 1. Ativa o controlador e o JSON
@RequestMapping("/api/courses")  //2. Define a rota base para todos os métodos
public class CourseController {
    
private final CourseService service;

private CourseController(CourseService service){
    this.service = service;
    }

    /** GET que busca os cursos */
    @GetMapping()
    public List<Course> buscaCourses (){
        return this.service.findAll();
    }

/** GET by Id */

    @GetMapping("/{id}")
    public Course buscaCoursePorId(@PathVariable @NotNull @Positive Long id){
    return this.service.findById(id);
    }

/**Método Post */

@PostMapping
    public ResponseEntity<Course> createdCourse(@RequestBody @Valid Course course) {
        Course localCourse = this.service.createdCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(localCourse);
    }

@DeleteMapping("/{id}")
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public void delete(@PathVariable @NonNull @Positive Long id) {
    this.service.deleteCourse(id);
    }

}
