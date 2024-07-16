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

    public Dictionary findDictionary(Dictionary dictionary) {
        return dictionaryRepository.findById(dictionary.getId()).orElse(null);
    }

    public List<Dictionary> findAllDictionaries(){
        return dictionaryRepository.findAll();
    }

    public String saveDictionary(Dictionary dictionary){
        if (dictionary == null){
            dictionary = Dictionary.defaultValue;
        }
        dictionaryRepository.save(dictionary);
        return "Dictionary saved";
    }

    public String deleteDictionary(Dictionary dictionary){
        if (dictionary == null){
            dictionary = findFirst();
            if (dictionary == null){
                return "All dictionaries already deleted";
            }
        }
        if (findDictionary(dictionary) == null){
            return "Dictionary does not exist";
        }
        dictionaryRepository.delete(dictionary);
        return "Dictionary deleted";
    }

    public Dictionary findFirst()
    {
        List<Dictionary> dictionaryList = dictionaryRepository.findAll();
        if(dictionaryList.isEmpty())
            return null;
        return dictionaryList.getFirst();
    }
}
