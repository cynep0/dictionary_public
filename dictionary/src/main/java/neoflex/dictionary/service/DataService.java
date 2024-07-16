package neoflex.dictionary.service;

import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Data;
import neoflex.dictionary.model.Dictionary;
import neoflex.dictionary.repository.DataRepository;
import neoflex.dictionary.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DataService {
    private final DataRepository dataRepository;
    private final DictionaryRepository dictionaryRepository;

    public Data findData(Data data) {
        return dataRepository.findById(data.getId()).orElse(null);
    }

    public List<Data> findAllData() {
        return dataRepository.findAll();
    }

    public List<Data> findAllDataByDictionary(UUID dictionaryId) {
        Dictionary dictionary = dictionaryRepository.findById(dictionaryId).orElse(null);
        if (dictionary == null) {
            return new ArrayList<>();
        }
        return dataRepository.findAllByDictionary(dictionary);
    }

    public Data saveData(Data data) {
        return dataRepository.save(data);
    }

    public void deleteData(Data data) {
        dataRepository.delete(data);
    }

    public Data findFirst()
    {
        List<Data> dataList = dataRepository.findAll();
        if (dataList.isEmpty())
            return null;
        return dataList.getFirst();
    }
}
