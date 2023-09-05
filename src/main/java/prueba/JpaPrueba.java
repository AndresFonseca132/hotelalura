package prueba;

import dao.HuespedDao;
import dao.ReservaDao;
import modelo.Huesped;
import modelo.Reserva;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class JpaPrueba {
    public static void main(String[] args) {

        Huesped huesped = new Huesped();
        huesped.setNombre("Juan");
        huesped.setApellido("Perez");
        huesped.setFechaNacimiento(LocalDate.of(1990, 5, 20));
        huesped.setNacionalidad("Colmbiano");
        huesped.setTelefono("3056728");
        huesped.setReserva(new Reserva());

        EntityManager em = JPAUtils.getEntityManager();

        ReservaDao reservaDao = new ReservaDao(em);
        HuespedDao huespedDao = new HuespedDao(em);
        //reservaDao.guardar(LocalDate.of(2023, 7, 20), LocalDate.of(2023, 7, 25), 200.0, "Efectivo");
        huespedDao.guardar("Juan", "Perez", LocalDate.of(1990, 5, 20), "Colombiano", "3056728", reservaDao.obtenerReserva(1l));

    }
}
