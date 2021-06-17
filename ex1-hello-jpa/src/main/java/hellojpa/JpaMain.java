package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("pizza");
            member.getFavoriteFoods().add("coke");

            member.getAddressHistory().add(new Address("old1", "street", "20000"));
            member.getAddressHistory().add(new Address("old2", "street", "20000"));

            em.persist(member);

            em.flush();
            em.close();

            System.out.println("++++++++++++++++++++++START+++++++++++++++++++++");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            findMember.getFavoriteFoods().remove("chinken");
            findMember.getFavoriteFoods().add("koreanFood");

            findMember.getAddressHistory().remove(new Address("old1", "street", "20000"));
            findMember.getAddressHistory().add(new Address("newCity1", "street", "20000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
