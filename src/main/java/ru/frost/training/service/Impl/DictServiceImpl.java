package ru.frost.training.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.frost.training.dto.CompanyInfoDto;
import ru.frost.training.gateway.FinancialGetway;
import ru.frost.training.service.DictService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {

    @Value("${financial.dictionary.key}")
    private String dictKey;

    private final FinancialGetway financialGetway;

    @Override
    public List<CompanyInfoDto> getCompanyList() {
        return financialGetway.getDictCompany().get(dictKey);
    }
}
