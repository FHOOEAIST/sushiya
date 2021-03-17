package science.aist.sushiya.core.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>Sample Domain Object, to test if everything works</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NonNull
    private String sampleData;
}
