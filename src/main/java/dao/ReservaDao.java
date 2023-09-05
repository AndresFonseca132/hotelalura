package dao;

import modelo.Reserva;

import javax.persistence.EntityManager;

public class ReservaDao {

    private EntityManager em;

    public ReservaDao(EntityManager em){this.em = em;}

    public void guardar(Reserva reserva){this.em.persist(reserva);}

    public void editar(Reserva reserva){this.em.merge(reserva);}

    public void remover(Reserva reserva) {
        reserva=this.em.merge(reserva);
        this.em.remove(reserva);
    }


}
