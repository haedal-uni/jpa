//package hellojpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml의 persistence-unit name이 hello
//        EntityManager em = emf.createEntityManager();
//
//        /* JPA는 트랜잭션이라는 단위가 중요하다.
//        JPA에서 데이터를 변경하는 모든 작업은 꼭 트랜잭션에서 작업해야한다. */
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//            // 이 시점에는 db에 안들어감
//
//            em.flush(); // 강제로 flush 해줘야한다.
//
//            List<Member> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER", Member.class)
//                    .getResultList();
//
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            e.printStackTrace();
//        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
//            em.close();
//        }
//
//        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
//    }
//}
