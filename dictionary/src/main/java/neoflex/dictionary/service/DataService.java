package neoflex.dictionary.service;

import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Data;
import neoflex.dictionary.model.Dictionary;
import neoflex.dictionary.repository.DataRepository;
import neoflex.dictionary.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DataService {
    private final DataRepository dataRepository;
    private final DictionaryRepository dictionaryRepository;

    public List<Data> findAllData() {
        return dataRepository.findAll();
    }

    public List<Data> findAllDataByDictionary(UUID dictionary_id) {
        return dataRepository.findAllByDictionary(dictionaryRepository.findById(dictionary_id));
    }

    public Data saveData(Data data) {
        return dataRepository.save(data);
    }

    public void deleteData(Data data) {
        dataRepository.delete(data);
    }
}
