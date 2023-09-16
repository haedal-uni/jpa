//package jpashop;
//
//import jpashop.domain.Book;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
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
//        try{
//            Book book = new Book();
//            book.setName("JPA");
//            book.setAuthor("J");
//
//            em.persist(book);
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
//            em.close();
//        }
//
//        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
//    }
//}
