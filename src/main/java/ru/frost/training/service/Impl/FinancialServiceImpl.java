package ru.frost.training.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.frost.training.dto.CompanyInfoDto;
import ru.frost.training.gateway.FinancialGetway;
import ru.frost.training.service.FinancialService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialServiceImpl implements FinancialService {

    @Value("${financial.price.key}")
    private String priceKey;

    private final FinancialGetway financialGetway;

    public List<CompanyInfoDto> getRTPriceList() {
        return financialGetway.getRTPriceList().get(priceKey);
    }

}
