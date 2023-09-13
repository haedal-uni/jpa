package jpashop;

import jpashop.domain.Order;
import jpashop.domain.OrderItem;

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

        try{
            // 예시 코드 (주문을 해야한다고 가정) _ 의사코드(pseudo code)
            // 1) 양방향 매핑 시
//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
//            em.persist(order);

            // 2) 단방향 매핑 시
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
            em.close();
        }

        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
    }
}
