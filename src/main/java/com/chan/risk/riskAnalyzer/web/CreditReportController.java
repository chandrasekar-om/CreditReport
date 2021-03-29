package com.chan.risk.riskAnalyzer.web;


import com.chan.risk.riskAnalyzer.service.CreditReport;
import com.chan.risk.riskAnalyzer.service.CreditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class CreditReportController {
    @Autowired
    private CreditReportService service;

    @GetMapping("/")
    public String showUserList(Model model) {
        List<CreditReport> list = service.getCreditReport();
        model.addAttribute("creditReport", service.getCreditReport());
        return "index";
    }

}
