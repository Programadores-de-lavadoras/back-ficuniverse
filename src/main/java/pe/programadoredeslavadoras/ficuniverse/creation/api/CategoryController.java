package pe.programadoredeslavadoras.ficuniverse.creation.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities.Category;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.service.CategoryService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping
    public List<Category> fetchAll(){
        return categoryService.getAll();
    }

    @GetMapping("{id}")
    public Category fetchById(@PathVariable("id") Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        return categoryService.delete(id);
    }
}
