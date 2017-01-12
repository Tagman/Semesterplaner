package Backend;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
            Termin ter2 = new Termin("Test2Termin", LocalTime.now(), LocalTime.now(), "4", 5, "400", LocalDate.now());

            Stundenplan testPlan = new Stundenplan(new ArrayList<>());
            Fach fach1 = new Fach("Fach1", new ArrayList<>());
            Einheit einheit1 = new Einheit(LocalTime.now(), LocalTime.MAX, "100", "Einheit1", "Ich", "Wöchetnluch", 5, "Vorlesung", LocalDate.now(), fach1);


            ter.setSemesterplan(sp);
            ter2.setSemesterplan(sp);

            sp.addTermin(ter);
            sp.addTermin(ter2);




            sp.setStundenplan(testPlan);
            testPlan.addFach(fach1);
            fach1.addEinheit(einheit1);

            entityManager.persist(sp);
            //entityManager.persist(ter);
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
            Long id2 = new Long(5);

            Semesterplan ausgabe1 = entityManager.find(Semesterplan.class,id);
            System.out.println(ausgabe1.getSemesterName());
            System.out.println("OneToMany: " + ausgabe1.getTermine().get(0).getBezeichnung());
            System.out.println("OneToMany: " + ausgabe1.getTermine().get(1).getBezeichnung());

            Einheit EinheitOut = ausgabe1.getStundenplan().getFaecher().get(0).getEinheiten().get(0);
            System.out.println(EinheitOut.getName());




            Termin terminausgabe = entityManager.find(Termin.class, id2);
            System.out.println("ManyToOne: " + terminausgabe.getBezeichnung());

            Semesterplan semplan = terminausgabe.getSemesterplan();
            System.out.println(semplan.getSemesterName());

            String klasse = "Termin.class";

            TypedQuery<Termin> query = entityManager.createQuery("SELECT t FROM Termin t", Termin.class);
            List<Termin> resultList = query.getResultList();

            System.out.println("Result: " + resultList.get(0).getBezeichnung());

        }catch (Exception e){
            logger.error("cannot query....");
            System.out.println(e.toString());

        }finally {
            entityManager.close();
        }

        emf.close();
    }
}
