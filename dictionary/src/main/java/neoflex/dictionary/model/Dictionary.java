package neoflex.dictionary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    private UUID id;
    @Schema(example = "код 1")
    @Column
    private String code;
    @Schema(example = "код 1")
    @Column
    private String description;
}
