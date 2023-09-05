package dao;

import modelo.Huesped;

import javax.persistence.EntityManager;

public class HuespedDao {

    private EntityManager em;

    public HuespedDao(EntityManager em) {this.em = em;}

    public void guardar(Huesped huesped) {this.em.persist(huesped);}

    public void actualizar(Huesped huesped) {this.em.merge(huesped);}

    public void remover(Huesped huesped) {
        huesped = this.em.merge(huesped);
        this.em.remove(huesped);
    }
}
