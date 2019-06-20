package ru.frost.training.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.frost.training.EntitiesPayload;
import ru.frost.training.dto.CompanyInfoDto;
import ru.frost.training.service.DictService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyInfoController {

    private final DictService dictService;

    @GetMapping(path = "/companies")
    @ResponseBody
    public ResponseEntity<EntitiesPayload<CompanyInfoDto>> getCompanyList() {
        return ResponseEntity.ok(new EntitiesPayload<>(dictService.getCompanyList()));
    }
}
