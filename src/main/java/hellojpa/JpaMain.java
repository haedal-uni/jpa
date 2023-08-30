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
            Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team); // 영속 상태가 되면 무조건 pk 값이 세팅되고 영속 상태가 된다.

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            //em.flush(); // 강제 호출 (영속성 컨텍스트에 있는 것들을 db에 쿼리를 날려버려서 싱크를 맞춤)
            //em.clear(); // 영속성 컨텍스트 초기화

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("= = = = = = = = =");
            for (Member m: members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            System.out.println("= = = = = = = = =");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally { // 작업이 끝나면 entityManager를 닫아준다.(사용을 하면 무조건 닫아줘야 한다) ★★★
            em.close();
        }

        emf.close(); // application이 완전히 끝나면 EntityManagerFactory를 닫아줘야 한다.
    }
}
