package com.chan.risk.riskAnalyzer.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getCreditReport() {
        Query q = entityManager.createNativeQuery("SELECT S.SUB_SECTOR_NAME AS SECTOR, SUM(DISTINCT F.UNPAID_AMOUNT) AS TOTAL_EXPOSURE, " +
                "COUNT(DISTINCT F.S_ID) AS NUM_OF_FACILITIE, COUNT(DISTINCT F.C_ID) AS NUM_OF_CUSTOMER " +
                "FROM CUSTOMER_FACILITIES F " +
                "RIGHT JOIN SECTOR S ON F.S_ID = S.sub_sector_id " +
                "RIGHT JOIN CUSTOMERS C ON F.C_ID = C.ID " +
                "WHERE C.ID  > 0 AND F.S_ID > 0 AND F.C_ID > 0 " +
                "GROUP BY S.SUB_SECTOR_NAME");
        List<Object[]> creditReport = q.getResultList();
        return creditReport;
    }
}
