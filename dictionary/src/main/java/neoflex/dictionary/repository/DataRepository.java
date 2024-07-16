package neoflex.dictionary.repository;

import neoflex.dictionary.model.Data;
import neoflex.dictionary.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DataRepository extends JpaRepository<Data, UUID> {
    public List<Data> findAllByDictionary(Dictionary dictionary);
}
