//package hellojpa;
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
//        try {
//            // 저장
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//
//            // = = collection = =
//            // hashset
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//
//            // 조회
//            em.flush();
//            em.clear();
//
//            System.out.println(" = = = = = =  START = = = = = = = ");
//            Member findMember = em.find(Member.class, member.getId());
///*
//            // 수정
//            // 값 타입
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            // 값 타입 컬렉션
//            // 치킨 → 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));
//*/
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
