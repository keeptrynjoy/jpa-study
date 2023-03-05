package jpql;


import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUserName("member1");
            member.setAge(10);
            em.persist(member);

            Member singleResult = em.createQuery("select m from Member m where m.userName =: userName", Member.class)
                    .setParameter("userName", "member1")
                    .getSingleResult();
            System.out.println("singleResult = " + singleResult.getUserName());


//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query.getResultList();
//
//            for (Member m : resultList)
//                System.out.println("m = " + m);

//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            Member singleResult = query.getSingleResult();
//
//            System.out.println("singleResult = " + singleResult);
//
//            Query query1 = em.createQuery("select m.userName, m.age from Member m");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
