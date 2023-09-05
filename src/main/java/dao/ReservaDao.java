package dao;

import modelo.Reserva;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaDao {

    private EntityManager em;

    public ReservaDao(EntityManager em){this.em = em;}

    public Reserva guardar(LocalDate fechaEntrada, LocalDate fechaSalida, Double valor, String formaDePago){
        Reserva reserva = new Reserva(fechaEntrada,fechaSalida,valor,formaDePago);
        em.getTransaction().begin();
        this.em.persist(reserva);
        em.getTransaction().commit();
        em.close();
        return reserva;
    }

    public void editar(JTable tablareservas){
    Integer filaSeleccionada = tablareservas.getSelectedRow();
    Long id = Long.parseLong(tablareservas.getValueAt(filaSeleccionada,0).toString());
    String fechaChekIn = tablareservas.getValueAt(filaSeleccionada,1).toString();
    String fechaChekOut = tablareservas.getValueAt(filaSeleccionada,2).toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaChekInModificada = LocalDate.parse(fechaChekIn,dtf);
        LocalDate fechaChekOutModificada = LocalDate.parse(fechaChekOut,dtf);
        Double valorModificado = Double.parseDouble(tablareservas.getValueAt(filaSeleccionada,3).toString());
        String FormaPago = tablareservas.getValueAt(filaSeleccionada,4).toString();

        em.getTransaction().begin();
        Reserva reserva = em.find(Reserva.class,id);
        if(reserva!=null){
            reserva.setFechaEntrada(fechaChekInModificada);
            reserva.setFechaSalida(fechaChekOutModificada);
            reserva.setValor(valorModificado);
            reserva.setFormaDePago(FormaPago);
            em.merge(reserva);
            em.getTransaction().commit();
    }
    else{
            em.getTransaction().rollback();
        }
        em.close();
    }


    public void remover(Reserva reserva) {
        reserva=this.em.merge(reserva);
        this.em.remove(reserva);
    }


    public Reserva obtenerReserva(long l) {
        return em.find(Reserva.class,l);
    }
}
