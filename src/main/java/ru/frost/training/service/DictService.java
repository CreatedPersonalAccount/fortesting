package ru.frost.training.service;

import ru.frost.training.dto.CompanyInfoDto;
import java.util.List;

public interface DictService {

    List<CompanyInfoDto> getCompanyList();
}
