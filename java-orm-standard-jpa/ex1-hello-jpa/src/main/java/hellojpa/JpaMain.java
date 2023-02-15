package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //emf는 application lording 시점에 딱 하나만 만들어두어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // JPA는 Tx를 얻어서 실행해야함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //추가
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");

            //조회
//            Member member = em.find(Member.class, 1L);//객체를 대신 저장해주는 메서드
//            System.out.println("member = " + member.getId());
//            System.out.println("member = " + member.getName());

            //삭제
//            em.remove(memver);

            //수정
//            Member member = em.find(Member.class, 1L);//객체를 대신 저장해주는 메서드
//            member.setName("HelloJPA");
//            em.persist(member);// Java collect 처럼 다루기에 따로 저장이 필요하지 않음

            List<Member> result = em.createQuery("select m from Member as m ", Member.class)
//                    .getResultList();
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(Member member :result){
                System.out.println("member = " + member.getName());
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
