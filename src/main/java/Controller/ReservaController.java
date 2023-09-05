package Controller;

import dao.ReservaDao;
import modelo.Reserva;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class ReservaController {

    private ReservaDao reservaDao;

    private EntityManager em;

    public ReservaController(){
        this.em = JPAUtils.getEntityManager();
        this.reservaDao = new ReservaDao(em);
    }

    public Reserva guardar(LocalDate fechaIngreso, LocalDate fechaSalida, Double valor, String formaDePago){
        return reservaDao.guardar(fechaIngreso, fechaSalida, valor, formaDePago);
    }

}
