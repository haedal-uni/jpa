package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 persistence-unit name이 hello
        EntityManager em = emf.createEntityManager();

        /* JPA는 트랜잭션이라는 단위가 중요하다.
        JPA에서 데이터를 변경하는 모든 작업은 꼭 트랜잭션에서 작업해야한다. */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 영속
            Member member = em.find(Member.class, 35L); // 영속 상태
            member.setName("aa"); // Dirty Checking

            em.detach(member); // jpa에서 더 이상 관리하지 x

            System.out.println("==================");
            tx.commit(); // 아무일도 일어나지 않는다(더 이상 jpa에서 관리하지 않으므로)
        }catch (Exception e){
            tx.rollback();
        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
            em.close();
        }

        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
    }
}
