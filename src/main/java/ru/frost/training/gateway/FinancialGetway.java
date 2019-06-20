package ru.frost.training.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.frost.training.dto.CompanyInfoDto;

import java.util.List;
import java.util.Map;


@FeignClient(name = "financialApi", url = "${financial.common-url}")
public interface FinancialGetway {

    @RequestMapping(method = RequestMethod.GET, path = "${financial.price.url}")
    Map<String, List<CompanyInfoDto>> getRTPriceList();

    @RequestMapping(method = RequestMethod.GET, path = "${financial.dictionary.url}")
    Map<String, List<CompanyInfoDto>> getDictCompany();
}
