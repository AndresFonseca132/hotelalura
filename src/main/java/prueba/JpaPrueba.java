package prueba;

import dao.ReservaDao;
import modelo.Reserva;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

public class JpaPrueba {
    public static void main(String[] args) {
        Reserva reserva = new Reserva();
        reserva.setFechaEntrada(new Date(2023, 7, 20));
        reserva.setFechaSalida(new Date(2023, 7, 23));
        reserva.setValor(new BigDecimal(230));

        EntityManager em = JPAUtils.getEntityManager();

        ReservaDao reservaDao = new ReservaDao(em);

        em.getTransaction().begin();

        reservaDao.guardar(reserva);

        em.getTransaction().commit();

        em.close();
    }
}
