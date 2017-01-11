package Backend;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Chris on 10.01.2017.
 */
public class DBTest {

    public static final Logger logger = Logger.getLogger(DBTest.class);

    public static void main(String[] args){

        logger.debug("starting db test");

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SemesterplanerPU");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = null;

        try{
            tx = entityManager.getTransaction();
            tx.begin();

            Semesterplan sp = new Semesterplan("Test2", LocalDate.now(), LocalDate.now(), new ArrayList<>());
            Termin ter = new Termin("TestTermin", LocalTime.now(), LocalTime.now(), "2", 3, "300", LocalDate.now());
            ter.setSemesterplan(sp);

            sp.addTermin(ter);

            entityManager.persist(sp);
            entityManager.persist(ter);
            tx.commit();
        }catch (Exception e){

            logger.error("cannot commit transaction...");
            System.out.println(e.toString());
            tx.rollback();
        }finally {
           // entityManager.close();
        }

        try{

            Long id = new Long(1);
            Long id2 = new Long(2);

            Semesterplan ausgabe1 = entityManager.find(Semesterplan.class,id);
            System.out.println(ausgabe1.getSemesterName());

            Termin terminausgabe = entityManager.find(Termin.class, id2);
            System.out.println(terminausgabe.getBezeichnung());
            Semesterplan semplan = terminausgabe.getSemesterplan();
            System.out.println(semplan.getSemesterName());

        }catch (Exception e){
            logger.error("cannot query....");
            System.out.println(e.toString());

        }finally {
            entityManager.close();
        }

        emf.close();
    }
}
