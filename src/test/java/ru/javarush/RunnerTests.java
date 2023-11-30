package ru.javarush;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.*;
import ru.javarush.lukyanov.hibernate2.entity.Actor;
import ru.javarush.lukyanov.hibernate2.entity.Category;
import ru.javarush.lukyanov.hibernate2.entity.Film;
import ru.javarush.lukyanov.hibernate2.entity.Language;

import java.util.Properties;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit tests
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RunnerTests {

    private SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    void setup() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
            properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            sessionFactory = new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Actor.class)
                    .addAnnotatedClass(Film.class)
                    .addAnnotatedClass(Language.class)
                    .addAnnotatedClass(Category.class)
                    .buildSessionFactory();
        } catch (RuntimeException exc) {
            exc.printStackTrace();
        }
    }

    @BeforeEach
    void setupThis() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @AfterEach
    void teardownThis() {
        session.getTransaction().commit();
    }

    @AfterAll
    void teardown() {
        sessionFactory.close();
    }

    @Test
    void testActorEqualsAssertion() {
        Actor actor = new Actor();
        actor.setFirstName("Ivan");
        actor.setLastName("Ivanov");
        actor.setActorId((short) 1);
        session.persist(actor);
        Actor gettedActor = session.get(Actor.class, 0);

        assertEquals("Ivan", gettedActor.getFirstName());
        assertEquals("Ivanov", gettedActor.getLastName());
    }

    @Test
    void testActorNotEqualsAssertion() {
        Actor actor = new Actor();
        actor.setFirstName("Ivan");
        actor.setLastName("Ivanov");
        actor.setActorId((short) 1);
        session.persist(actor);
        Actor gettedActor = session.get(Actor.class, 0);

        assertNotEquals("Petr", gettedActor.getFirstName());
        assertNotEquals("Petrov", gettedActor.getLastName());
    }

    @Test
    void testActorNullFirstNameAssertion() {
        Actor actor = new Actor();
        actor.setLastName("Ivanov");
        actor.setActorId((short) 1);
        session.persist(actor);
        Actor gettedActor = session.get(Actor.class, 0);

        assertNull(gettedActor.getFirstName());
    }

    @Test
    void testActorNotNullLastNameAssertion() {
        Actor actor = new Actor();
        actor.setLastName("Ivanov");
        actor.setActorId((short) 1);
        session.persist(actor);
        Actor gettedActor = session.get(Actor.class, 0);

        assertNotNull(gettedActor.getLastName());
    }
}
