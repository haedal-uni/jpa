package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 persistence-unit name이 hello
        EntityManager em = emf.createEntityManager();

        /* JPA는 트랜잭션이라는 단위가 중요하다.
        JPA에서 데이터를 변경하는 모든 작업은 꼭 트랜잭션에서 작업해야한다. */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 회원 등록
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            em.persist(member); // 저장


            // 회원 조회
            Member findMember = em.find(Member.class, 1L);
            Long id = findMember.getId();


            // 회원 삭제
            em.remove(findMember);


            // 회원 수정
            Member updateMember = em.find(Member.class, 1L);
            updateMember.setName("Hello JPA");
            // em.persist(updateMember); → 저장 안해도 된다.


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
            em.close();
        }

        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
    }
}
