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
@RequestMapping("/api/v0/dictionary")
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
    @PostMapping("save_dictionary")
    public String saveDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.saveDictionary(dictionary);
        return "Dictionary saved";
    }

    @Operation(
            summary = "удаляет Dictionary",
            responses = {
            @ApiResponse(description = "возвращает Dictionary deleted")
            }
    )
    @DeleteMapping("delete_dictionary")
    public String deleteDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.deleteDictionary(dictionary);
        return "Dictionary deleted";
    }
}
