package Spring.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    public int id;
    public String name;
    public String description;
    public float price;
    public float quantity;
}
