package neoflex.dictionary.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Data;
import neoflex.dictionary.service.DataService;
import neoflex.dictionary.service.DictionaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/data")
@Tag(name="DataController", description="Контролер для управлением Data")
public class DataController {
    private DataService dataService;

    @Operation(
            summary = "Выводить все Data"
    )
    @GetMapping
    public List<Data> findAllData() {
        return dataService.findAllData();
    }

    @Operation(
            summary = "Выводить все Data которые принадлежат Dictionary"
    )
    @GetMapping("/{dictionaryId}")
    public List<Data> findAllDataById(@PathVariable@Parameter(description = "Идентификатор Dictionary") UUID dictionaryId) {
        return dataService.findAllDataByDictionary(dictionaryId);
    }


    @Operation(
            summary = "сохраняет Data",
            responses = {
            @ApiResponse(description = "возвращает Data saved или this dictionary does not exist если данного dictionary не существует")
            }
    )
    @PostMapping
    public String saveData(@RequestBody(required = false) Data data) {
        return dataService.saveData(data);
    }

    @Operation(
            summary = "удаляет Data",
            responses = {
                    @ApiResponse(description = "возвращает Data deleted или all data already deleted если при удалении по умолчанию нет ни одного data или data does not exist если данного data не существует")
            }
    )
    @DeleteMapping
    public String deleteData(@RequestBody(required = false) Data data) {
        return dataService.deleteData(data);
    }
}