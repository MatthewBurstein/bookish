package training.bookish.services;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.bookish.models.Loan;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class LoanService {

    @Autowired
    private EntityManager entityManager;

    public List<Loan> getUserLoans(int userId) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Loan> query = criteria.createQuery(Loan.class);
        Root<Loan> loan = query.from(Loan.class);
        query.select(loan)
                .where(criteria.equal(
                        loan.get("user").get("id"),
                        userId));
        return entityManager.createQuery(query).getResultList();
    }
}
