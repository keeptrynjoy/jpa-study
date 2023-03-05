
package jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpaMain8 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            em.persist(team);

            Member member = new Member();
            member.setUserName("관리자 1");
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setUserName("관리자 2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            // 단일 값 연관 경로
//            String query = "select m.team from Member m";
//            List<Team> result = em.createQuery(query, Team.class).getResultList();
//
//            for (Team s : result) {
//                System.out.println("s = " + s);
//            }

            // 컬렉션 값 연관 경로 - 추가 탐색이 안됨
            String query = "select t.members from Team t";

            List<Collection> result = em.createQuery(query, Collection.class)
                    .getResultList();

            System.out.println("result = " + result);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
