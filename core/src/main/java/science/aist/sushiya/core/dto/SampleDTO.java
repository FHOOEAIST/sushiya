package science.aist.sushiya.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>DTO object matching {@link science.aist.sushiya.core.domain.Sample}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDTO {
    @NotEmpty(message = "Please provide sampleData")
    private String sampleData;
}
