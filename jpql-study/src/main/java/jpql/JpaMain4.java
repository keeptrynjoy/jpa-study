package jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);


            Member member = new Member();
            member.setUserName("member1");
            member.setAge(10);
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            // 세타조인
//            String query = "select m from Member m, Team t where m.userName = t.name";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

            // on절 - 조인 대상 필터링
//            String query = "select m from Member m left join m.team t on t.name ='teamA'";
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

            // on절 - 연관관계 없는 엔티티 외부 조인
            String query = "select m from Member m left join Team t on m.userName = t.name";
            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
