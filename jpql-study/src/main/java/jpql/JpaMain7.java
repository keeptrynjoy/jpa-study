
package jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = new Member();
            member.setUserName("관리자 1");
            em.persist(member);

            Member member2 = new Member();
            member2.setUserName("관리자 2");
            em.persist(member2);

            em.flush();
            em.clear();

//            String query = "select 'a' || 'b' from Member m"; //concat('a','b')
//            List<String> result = em.createQuery(query, String.class).getResultList();
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

//            String query = "select locate('de','abcdegf') from Member m";
//            List<Integer> result = em.createQuery(query, Integer.class).getResultList();
//            for (Integer i : result) {
//                System.out.println("i = " + i);
//            }

//            String query = "select size(t.members) from Team t";
//            List<Integer> result = em.createQuery(query, Integer.class).getResultList();
//            for (Integer i : result) {
//                System.out.println("i = " + i);
//            }

            //사용자 정의 함수 - 선언된 커스텀 함수를 사용(dialect > MyH2Dialect)
//            String query = "select function('group_concat',m.userName) from Member m";
            String query = "select group_concat(m.userName) from Member m";
            List<String> result = em.createQuery(query, String.class).getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
