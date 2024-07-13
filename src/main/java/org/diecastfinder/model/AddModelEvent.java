package org.diecastfinder.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddModelEvent implements Serializable {

    private static final long serialVersionUID = -5226814208277322666L;
    private FoundModelDto foundModelDto;

}
