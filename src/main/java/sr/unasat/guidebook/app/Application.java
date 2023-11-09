package sr.unasat.guidebook.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import sr.unasat.guidebook.database.DatabasePersistenceConnection;
import sr.unasat.guidebook.entities.Guide;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new DatabasePersistenceConnection(), new HashMap<>());

        EntityManager em = emf.createEntityManager();

        try {

            int id = 1;
            String address = "Hindilaan";

            Guide guide = new Guide();
            guide.setId(id);
            guide.setAddress(address);

            em.getTransaction().begin();
            em.persist(guide);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
