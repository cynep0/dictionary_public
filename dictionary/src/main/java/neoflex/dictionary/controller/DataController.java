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

    private final DictionaryService dictionaryService;
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
    @PostMapping("data")
    public String saveData(@RequestBody(required = false) Data data) {
        if (data == null) {
            data = Data.defaultValue;
        }
        if (dictionaryService.findDictionary(data.getDictionary()) == null){
            return "this dictionary does not exist";
        }
        dataService.saveData(data);
        return "data saved";
    }

    @Operation(
            summary = "удаляет Data",
            responses = {
                    @ApiResponse(description = "возвращает Data deleted или all data already deleted если при удалении по умолчанию нет ни одного data или data does not exist если данного data не существует")
            }
    )
    @DeleteMapping("data")
    public String deleteData(@RequestBody(required = false) Data data) {
        if (data == null) {
            data = dataService.findFirst();
            if (data == null) {
                return "all data already deleted";
            }
        }
        if (dataService.findData(data) == null) {
            return "data does not exist";
        }
        dataService.deleteData(data);
        return "data deleted";
    }
}