
package Dao;

import Entity.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taynara
 */
public class AgendaDAO extends MySQL{
     public boolean insert(Agenda agenda) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO agenda "
                            + "(sala,custoPorHora) "
                            + "VALUES ( ?, ?)");
            ps.setInt(1, agenda.getSala());
            ps.setDouble(2, agenda.getCustoPorHora());
            

            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean update(Agenda agenda) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE agenda "
                    + "SET sala = ? , custoPorHora = ? ");
            ps.setInt(1, agenda.getSala());
            ps.setInt(2, agenda.getId());
            ps.setDouble(3, agenda.getCustoPorHora());
 
            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM agenda "
                            + "WHERE idAgenda = ?");
            ps.setInt(1, id);

            ps.execute();

            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Agenda> listarAgenda() {
        List<Agenda> lista = new ArrayList<Agenda>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idAgenda, sala, custoPorHora "
                            + "FROM agenda");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda() {};
                agenda.setId(rs.getInt("idAgenda"));
                agenda.setSala(rs.getInt("sala"));
                agenda.setCustoPorHora(rs.getDouble("custoPorHora"));
                
                lista.add(agenda);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    public Agenda getAgendaById(int id) {
        Connection c = this.getConnection();
        Agenda agenda = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idAgenda, "
                    + "sala, custoPorHora "
                    + "FROM agenda WHERE idAgenda = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                agenda = new Agenda() {};
                agenda.setId(rs.getInt("idAgenda"));
                agenda.setSala(rs.getInt("sala"));
                agenda.setCustoPorHora(rs.getDouble("custoPorHora"));
             
            }
            rs.close();
            ps.close();
            return agenda;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
