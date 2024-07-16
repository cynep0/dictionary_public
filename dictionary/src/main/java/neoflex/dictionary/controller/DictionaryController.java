package neoflex.dictionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Dictionary;
import neoflex.dictionary.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/dictionary")
@Tag(name="DictionaryController", description="Контролер для управлением Dictionary")
public class DictionaryController {

    private DictionaryService dictionaryService;

    @Operation(
            summary = "выводит все Dictionary"
    )
    @GetMapping
    public List<Dictionary> findAllDictionaries() {
        return dictionaryService.findAllDictionaries();
    }

    @Operation(
            summary = "сохраняет Dictionary",
            responses = {
                    @ApiResponse(description = "возвращает Dictionary saved")
            }
    )
    @PostMapping("dictionaries")
    public String saveDictionary(@RequestBody(required = false) Dictionary dictionary) {
        if (dictionary == null){
            dictionary = Dictionary.defaultValue;
        }
        dictionaryService.saveDictionary(dictionary);
        return "Dictionary saved";
    }

    @Operation(
            summary = "удаляет Dictionary",
            responses = {
            @ApiResponse(description = "возвращает Dictionary deleted или all dictionaries already deleted если при удалении по умолчанию нет ни одного dictionary или Dictionaries does not exist если данного dictionary не существует")
            }
    )
    @DeleteMapping("dictionaries")
    public String deleteDictionary(@RequestBody(required = false) Dictionary dictionary) {
        if (dictionary == null){
            dictionary = dictionaryService.findFirst();
            if (dictionary == null){
                return "All dictionaries already deleted";
            }
        }
        if (dictionaryService.findDictionary(dictionary) == null){
            return "Dictionary does not exist";
        }
        dictionaryService.deleteDictionary(dictionary);
        return "Dictionary deleted";
    }
}
