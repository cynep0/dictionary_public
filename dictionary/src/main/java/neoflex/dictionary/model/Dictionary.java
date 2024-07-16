package neoflex.dictionary.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@lombok.Data
@Entity
public class Dictionary {
    @Id
    private UUID id;
    @Schema(example = "код 1")
    @Column
    private String code;
    @Schema(example = "код 1")
    @Column
    private String description;
    public Dictionary(String code, String description) {
        id = UUID.randomUUID();
        this.code = code;
        this.description = description;
    }
    public static Dictionary defaultValue = new Dictionary("defaultCode", "defaultDescription");
    public Dictionary() {}
}
