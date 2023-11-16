package pe.programadoredeslavadoras.ficuniverse.creation.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities.Chapter;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.persistence.ChapterRepository;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.service.ChapterService;
import pe.programadoredeslavadoras.ficuniverse.shared.exceptions.FetchIdNotFoundException;
import pe.programadoredeslavadoras.ficuniverse.shared.exceptions.FetchNotFoundException;
import pe.programadoredeslavadoras.ficuniverse.shared.exceptions.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final Validator validator;


    @Override
    public Chapter save(Chapter chapter) {
        Set<ConstraintViolation<Chapter>> violation = validator.validate(chapter);
        if(violation.isEmpty()){
            return chapterRepository.save(chapter);
        }
        throw new ResourceValidationException("Chapter",violation);
    }

    @Override
    public Chapter update(Chapter chapter) {
        return null;
    }

    @Override
    public List<Chapter> fetchAll() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter fetchById(Integer id) {
        if(chapterRepository.existsById(id)){
            return chapterRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("Chapter", id);
    }

    @Override
    public Chapter fetchByTitle(String title) {
        Optional<Chapter> optionalChapter = chapterRepository.sqlChapterByTitle(title);
        if(optionalChapter.isPresent()){
            return optionalChapter.get();
        }
        throw new FetchNotFoundException("Chapter"," title", title);

    }

    @Override
    public boolean deleteById(Integer id) {
        if (chapterRepository.existsById(id)){
            chapterRepository.deleteById(id);
            if(chapterRepository.existsById(id)){
                return false;
            }
            return true;
        }
        throw new FetchIdNotFoundException("Chapter", id);
    }

    @Override
    public List<Chapter> fetchChaptersByFanficId(Integer fanficId) {
        //return chapterRepository.findChaptersByFanficId(fanficId);
        return chapterRepository.sqlChaptersByFanficId(fanficId);
    }

    @Override
    public List<Chapter> fetchByChapterOrderBetween(Integer orderInit, Integer orderEnd) {
        return chapterRepository.sqlChaptersBetweenChapterOrder(orderInit,orderEnd);
    }
}
