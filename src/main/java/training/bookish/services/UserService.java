package training.bookish.services;

import training.bookish.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager entityManager;

    public User getUser(String username) {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteria.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user)
                .where(criteria.equal(
                        user.get("username"),
                        username));
        return entityManager.createQuery(query).getSingleResult();
    }
}
