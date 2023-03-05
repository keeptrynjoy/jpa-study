//package hellojpa;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try{
////
////            Member member = new Member(200L,"member200");
////            em.persist(member);
////            em.flush();
//
//            //영속상태
//            Member member = em.find(Member.class, 200L);
//            //dirty checking
//            member.setName("AAAAA");
//
//            //준영속상태. JPA에서 관리하지 않게 되기 때문에 DB에 반영안됨.
////            em.detach(member);
//
//            //영속성 컨텍스트 완전 초기화
//            em.clear();
//
//            //clear() 후 조회시 처음부터 영속성 컨텍스트에 올림
//            Member member2 = em.find(Member.class, 200L);
//
//            System.out.println("=================");
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
