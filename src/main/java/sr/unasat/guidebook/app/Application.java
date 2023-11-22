package sr.unasat.guidebook.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;
import sr.unasat.guidebook.database.DatabasePersistenceConnection;
import sr.unasat.guidebook.entities.Address;
import sr.unasat.guidebook.entities.Guide;
import sr.unasat.guidebook.entities.User;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new DatabasePersistenceConnection(), new HashMap<>());

        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            String hql = "SELECT u FROM User u WHERE u.status = false ";
            TypedQuery<User> typedQuery = em.createQuery(hql, User.class);
//            List<User> dienstList = typedQuery.getResultList();
            System.out.println(typedQuery.getResultList());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
