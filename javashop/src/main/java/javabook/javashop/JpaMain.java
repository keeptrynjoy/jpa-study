package javabook.javashop;

import javabook.javashop.domain.Book;
import javabook.javashop.domain.Order;
import javabook.javashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

            EntityManager em = emf.createEntityManager();

            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                Book book = new Book();
                book.setAuthor("김영한");
                book.setName("JPA");

                OrderItem orderItem1 = new OrderItem();
                orderItem1.setItem(book);

                Order order = new Order();
                order.addOrderItem(orderItem1);

                em.persist(order);

                em.persist(book);

                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            } finally {
                em.close();
            }
            emf.close();
        }


}
