package training.bookish.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training.bookish.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private EntityManager entityManager;

    public List<Book> getBooks() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteria.createQuery(Book.class);
        Root<Book> book = query.from(Book.class);
        query.select(book)
            .orderBy(criteria.asc(book.get("title")));
        return entityManager.createQuery(query).getResultList();
    }

    public Book find(int bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public void create(Book book) {
        entityManager.persist(book);
    }
}
