
package jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain11 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUserName("회원 1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("회원 2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUserName("회원 3");
            member3.setTeam(teamB);
            em.persist(member3);

            //벌크 연산 -> flush
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            System.out.println("resultCount = " + resultCount);

            // 영속성 컨텍스트가 초기화 되지 않았기에 값이 그대로 나옴
//            System.out.println("member1.getAge() = " + member1.getAge());
//            System.out.println("member2.getAge() = " + member2.getAge());
//            System.out.println("member3.getAge() = " + member3.getAge());

            em.clear();

            // 영속성 컨텍스트 초기화 후 조회 했기에 벌크 연산이 수행된 값으로 가져와짐
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember.getAge() = " + findMember.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
