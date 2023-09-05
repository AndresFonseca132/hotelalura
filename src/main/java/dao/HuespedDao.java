package dao;

import modelo.Huesped;
import modelo.Reserva;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class HuespedDao {

    private EntityManager em;

    public HuespedDao(EntityManager em) {this.em = em;}

    public void guardar(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad,
                        String telefono, Reserva reserva) {

        Huesped huesped = new Huesped(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, reserva);
        em.getTransaction().begin();
        this.em.persist(huesped);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizar(Huesped huesped) {this.em.merge(huesped);}

    public void remover(Huesped huesped) {
        huesped = this.em.merge(huesped);
        this.em.remove(huesped);
    }
}
