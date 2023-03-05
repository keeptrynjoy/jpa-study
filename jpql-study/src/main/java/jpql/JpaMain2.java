//package jpql;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain2 {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try{
//            Member member = new Member();
//            member.setUserName("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            List<Member> result = em.createQuery("select m from Member m", Member.class)
////                    .getResultList();
////
////            Member findMember = result.get(0);
////            findMember.setAge(20);
//
//              // 묵시적 조인
////            List<Team> result = em.createQuery("select t from Member m join m.team t", Team.class)
////                    .getResultList();
//
////            em.createQuery("select o.address from Order o",Address.class)
////                    .getResultList();
//
////            em.createQuery("select distinct m.userName, m.age from Member m")
////                    .getResultList();
//
//            // 프로젝션으로 여러 값 조회 방법 -  Query 타입 조회
////            List resultList = em.createQuery("select m.userName, m.age from Member m")
////                    .getResultList();
////
////            Object o = resultList.get(0);
////
////            Object[] result = (Object[]) o;
////
////            System.out.println("userName = " + result[0]);
////            System.out.println("age = " + result[1]);
//
//            // 프로젝션으로 여러 값 조회 방법 -  Query 타입 조회
////            List<Object[]> resultList = em.createQuery("select m.userName, m.age from Member m")
////                    .getResultList();
////
////            Object[] result = resultList.get(0);
////            System.out.println("userName = " + result[0]);
////            System.out.println("age = " + result[1]);
//
//            // 프로젝션으로 여러 값 조회 방법 -  New 명령어로 조회
//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.userName, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = resultList.get(0);
//            System.out.println("userName = " + memberDTO.getUserName());
//            System.out.println("age = " + memberDTO.getAge());
//
//            tx.commit();
//
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        emf.close();
//    }
//}
