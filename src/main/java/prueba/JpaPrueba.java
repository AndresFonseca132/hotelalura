package prueba;

import dao.HuespedDao;
import dao.ReservaDao;
import modelo.Huesped;
import modelo.Reserva;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JpaPrueba {
    public static void main(String[] args) {
        Reserva reserva = new Reserva();
        reserva.setFechaEntrada(LocalDate.of(2023, 7, 20));
        reserva.setFechaSalida(LocalDate.of(2023, 7, 25));
        reserva.setValor(new BigDecimal(230));

        Huesped huesped = new Huesped();
        huesped.setNombre("Juan");
        huesped.setApellido("Perez");
        huesped.setFechaNacimiento(LocalDate.of(1990, 5, 20));
        huesped.setNacionalidad("Colmbiano");
        huesped.setTelefono("3056728");
        huesped.setReserva(reserva);

        EntityManager em = JPAUtils.getEntityManager();

        ReservaDao reservaDao = new ReservaDao(em);
        HuespedDao huespedDao = new HuespedDao(em);

        em.getTransaction().begin();

        reservaDao.guardar(reserva);
        huespedDao.guardar(huesped);

        em.getTransaction().commit();

        em.close();
    }
}
