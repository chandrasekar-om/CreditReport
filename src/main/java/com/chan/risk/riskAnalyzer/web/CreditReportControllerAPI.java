package com.chan.risk.riskAnalyzer.web;


import com.chan.risk.riskAnalyzer.service.CreditReport;
import com.chan.risk.riskAnalyzer.service.CreditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class CreditReportControllerAPI {
    @Autowired
    private CreditReportService service;

    @GetMapping("/credit")
    public ResponseEntity<List<CreditReport>> getAllCreditReport() {
        List<CreditReport> list = service.getCreditReport();
        return new ResponseEntity<List<CreditReport>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
