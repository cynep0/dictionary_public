package neoflex.dictionary.service;

import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Dictionary;
import neoflex.dictionary.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryService {
    private final DictionaryRepository dictionaryRepository;

    public List<Dictionary> findAllDictionaries(){
        return dictionaryRepository.findAll();
    }

    public Dictionary saveDictionary(Dictionary dictionary){
        return dictionaryRepository.save(dictionary);
    }

    public void deleteDictionary(Dictionary dictionary){
        dictionaryRepository.delete(dictionary);
    }
}
