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
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); // 특정 엔티티만 준영속 상태로 전환 -> select query 만 나가고 update query 는 나가지 않는다.
            System.out.println("============");

            // 커밋하는 순간 데이터베이스에 insert sql 을 보낸다
            tx.commit(); // [트랜잭션] 커밋
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();




    }
}
