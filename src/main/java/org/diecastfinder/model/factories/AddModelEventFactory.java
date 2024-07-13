package org.diecastfinder.model.factories;

import org.diecastfinder.model.AddModelEvent;
import org.diecastfinder.model.FoundModelDto;

public class AddModelEventFactory {
    public static AddModelEvent getAddModelEvent(FoundModelDto model) {
        return AddModelEvent.builder()
            .foundModelDto(model)
            .build();
    }
}
