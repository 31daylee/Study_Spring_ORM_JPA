package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        // 엔티티 매니저는 데이터 변경시 트랜잭션 시작
        tx.begin(); // [트랜잭션] 시작

        try {
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==============");

            em.persist(member1); // 1, 51 까지의 공간을 확보 (DB에 다녀옴)
            em.persist(member2); // Memory에만 갔다옴 -> sequence 전략으로 하면 한 번에 모았다가 저장하는게 가능
            em.persist(member3); // Memory

            System.out.println("member1 : "+ member1.getId());
            System.out.println("member2 : "+ member2.getId());
            System.out.println("member3 : "+ member3.getId());
            System.out.println("==============");

            tx.commit(); // [트랜잭션] 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();




    }
}
