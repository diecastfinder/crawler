package org.diecastfinder.crawler.web.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@ToString
public class WantedModelDto {
    private UUID id;

    private String name;
    private String producer;
    private Integer minPrice;
    private Integer maxPrice;
    private String currency;
    private boolean active;
}
