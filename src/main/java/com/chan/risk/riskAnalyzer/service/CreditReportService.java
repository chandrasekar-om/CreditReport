package com.chan.risk.riskAnalyzer.service;

import com.chan.risk.riskAnalyzer.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<CreditReport> getCreditReport() {
        List<Object[]> creditReport = reportRepository.getCreditReport();
        List<CreditReport> report = new ArrayList<>();
        for (Object[] a : creditReport) {
            CreditReport c = new CreditReport(String.valueOf(a[0]), Double.valueOf(String.valueOf(a[1])), Integer.valueOf(String.valueOf(a[2])), Integer.valueOf(String.valueOf(a[3])));
            report.add(c);
            System.out.println("Service "
                    + c.getSector()
                    + " "
                    + c.getTotalExposure()
                    + " "
                    + c.getNumberOfFacilities()
                    + " "
                    + c.getNumberOfCustomers());
        }
        return report;
    }
}
