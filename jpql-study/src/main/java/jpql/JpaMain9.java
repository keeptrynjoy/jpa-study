
package jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpaMain9 {
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

            em.flush();
            em.clear();


//            String query = "select m from Member m join FETCH m.team";
//
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUserName() +
//                        ", " + member.getTeam().getName());
//
//                //회원 1, 팀A(SQL)
//                //회원 2, 팀A(1차캐시)
//                //회원 3, 팀B(SQL)
//
//                //회원 100명 -> 최악의 경우 N + 1 문제 발생
//            }

            //컬렉션 페치 조인
//            String query = "select t from Team t join FETCH t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() +
//                        "|members = " + team.getMembers().size());
//                for(Member member : team.getMembers()){
//                    System.out.println("-> member = " + member);
//                }
//            }


            //페치 조인과 DISTINCT
//            String query = "select distinct t from Team t join FETCH t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team team : result) {
//                System.out.println("team = " + team.getName() +
//                        "|members = " + team.getMembers().size());
//                for(Member member : team.getMembers()){
//                    System.out.println("-> member = " + member);
//                }
//            }

            //컬렉션 페치 조인 + 페이징 + BatchSize(size = 100)
            String query = "select t from Team t ";

            List<Team> result = em.createQuery(query, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();

            System.out.println("result.size() = " + result.size());

            for (Team team : result) {
                System.out.println("team = " + team.getName() +
                        "|members = " + team.getMembers().size());
                for(Member member : team.getMembers()){
                    System.out.println("-> member = " + member);
                }
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
