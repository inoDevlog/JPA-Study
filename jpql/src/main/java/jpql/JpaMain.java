/*
 * Copyright (c) 2021, ino, Inc. All rights reserved.
 */

package jpql;

import com.sun.corba.se.spi.ior.ObjectKey;

import javax.persistence.*;
import java.util.List;

/**
 * <b>클래스 제목(작업목적)</b>
 * <p>
 * 작업내용
 * </p>
 *
 * @author Choi, Inho <inho.choi@softwareinlife.com>
 * @since 2021/06/27
 */
public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

            // flush
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            System.out.println("resultCount = " + resultCount);

//            List<Member> resultList = em.createNamedQuery("Member.findByUserName", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }


//            String query = "select m From Member m where m = :member";
//
//            List<Member> findMember = em.createQuery(query, Member.class)
//                    .setParameter("member", member1)
//                    .getResultList();
//
//            System.out.println("findMember = " + findMember);

//            System.out.println("result = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team. = " + team.getName() + "|members = " + team.getMembers());
//                for (Member member : team.getMembers()) {
//                    System.out.println("-> member = " + member);
//                }
//            }

            tx.commit();
        } catch (
                Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
