package ru.frost.training;

import lombok.Data;
import ru.frost.training.dto.CompanyInfoDto;

import java.util.Collection;

@Data
public class EntitiesPayload<T> {

    private Collection<T> data;
    private int count;

    public EntitiesPayload(Collection<T> data) {
        this.data = data;
        this.count = data.size();
    }

    public EntitiesPayload(CompanyInfoDto companyInfoDto) {
    }
}
