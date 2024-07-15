package neoflex.dictionary.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.UUID;

@lombok.Data
@Entity
public class Data {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Dictionary dictionary;
    @Column
    @Schema(example = "код 1")
    private String code;
    @Schema(example = "значение 1")
    @Column
    private String value;
}
