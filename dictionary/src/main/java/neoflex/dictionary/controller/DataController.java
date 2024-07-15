package neoflex.dictionary.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import neoflex.dictionary.model.Data;
import neoflex.dictionary.model.Dictionary;
import neoflex.dictionary.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v0/data")
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
    @GetMapping("/{dictionary_id}")
    public List<Data> findAllDataById(@PathVariable@Parameter(description = "Идентификатор Dictionary") UUID dictionary_id) {
        return dataService.findAllDataByDictionary(dictionary_id);
    }


    @Operation(
            summary = "сохраняет Data",
            responses = {
            @ApiResponse(description = "возвращает Data saved")
            }
    )
    @PostMapping("save_data")
    public String saveData(@RequestBody Data data) {
        dataService.saveData(data);
        return "data saved";
    }

    @Operation(
            summary = "удаляет Data",
            responses = {
                    @ApiResponse(description = "возвращает Data deleted")
            }
    )
    @DeleteMapping("delete_data")
    public String deleteData(@RequestBody Data data) {
        dataService.deleteData(data);
        return "data deleted";
    }
}