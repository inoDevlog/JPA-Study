package hellojpa;

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

            Member member = new Member();
            member.setId(1L);
            member.setUsername("C");

            em.persist(member);

//            Member member1 = new Member(150L, "A");
            //영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA"); // 값만 바꾸는게 맞다.

            //준영속상태
//            em.detach(member);

//            Member member = new Member(200L, "member2000");
//            em.persist(member);

//            em.flush();
//            System.out.println("====================");
//            em.remove(member);
//            em.persist(member);
//            System.out.println("==================");
            tx.commit(); // 커밋하는 시점에 DB로 날아간다.
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
