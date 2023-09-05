package dao;

import modelo.Reserva;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaDao {

    private EntityManager em;

    public ReservaDao(EntityManager em){this.em = em;}

    public void guardar(LocalDate fehcaEntrada, LocalDate fechaSalida, BigDecimal valor, String formaDePago){
        Reserva reserva = new Reserva(fehcaEntrada,fechaSalida,valor,formaDePago);
        em.getTransaction().begin();
        this.em.persist(reserva);
        em.getTransaction().commit();
        em.close();
    }

    public void editar(Reserva reserva){this.em.merge(reserva);}

    public void remover(Reserva reserva) {
        reserva=this.em.merge(reserva);
        this.em.remove(reserva);
    }


}
