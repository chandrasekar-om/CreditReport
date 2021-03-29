package com.chan.risk.riskAnalyzer;

import static org.assertj.core.api.Assertions.assertThat;

import com.chan.risk.riskAnalyzer.model.Customer;
import com.chan.risk.riskAnalyzer.model.CustomerFacilities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("joins")
public class ReportRepositoryTests {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT e FROM Customer e", Customer.class);

        List<Customer> resultList = query.getResultList();

        assertThat(resultList).hasSize(10);
        assertThat(resultList).extracting("firstName")
                .contains("Harish", "Harini");
    }

    @Test
    public void whenMultipleEntities() {
        TypedQuery<CustomerFacilities> query = entityManager.createQuery("SELECT f FROM CustomerFacilities f JOIN f.sector s JOIN f.customer c WHERE c.id > 0", CustomerFacilities.class);

        List<CustomerFacilities> resultList = query.getResultList();

        assertThat(resultList).hasSize(6);
        assertThat(resultList).extracting("unpaidAmount")
                .contains(950000.0);
    }

    @Test
    public void whenMultipleEntitiesWithGroup() {
        /*TypedQuery<CustomerFacilities> query = entityManager.createQuery("SELECT f FROM CustomerFacilities f JOIN f.sector s JOIN f.customer c WHERE c.id > 0 group by f.sector", CustomerFacilities.class);

        List<CustomerFacilities> resultList = query.getResultList();

        assertThat(resultList).hasSize(6);
        assertThat(resultList).extracting("unpaidAmount")
                .contains(950000.0);*/

        Query q = entityManager.createNativeQuery("SELECT S.SUB_SECTOR_NAME AS SECTOR, SUM(F.UNPAID_AMOUNT) AS TOTAL_EXPOSURE, COUNT(S.FACILITIE_ID) AS NUM_OF_FACILITIE, COUNT(C.ID) AS NUM_OF_CUSTOMER " +
                "FROM CUSTOMER_FACILITIES F " +
                "LEFT JOIN SECTOR S ON F.S_ID = S.ID " +
                "LEFT JOIN CUSTOMERS C ON F.C_ID = C.ID " +
                "WHERE C.ID  > 0 " +
                "GROUP BY S.SUB_SECTOR_NAME");
        List<Object[]> authors = q.getResultList();
        for (Object[] a : authors) {
            System.out.println("Author "
                    + a[0]
                    + " "
                    + a[1]);
        }

    }
}
