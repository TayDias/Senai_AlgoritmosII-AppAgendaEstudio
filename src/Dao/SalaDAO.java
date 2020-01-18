
package Dao;

import Entity.Sala;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taynara
 */
public class SalaDAO extends MySQL{
    public boolean insert(Sala sala) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO sala "
                            + "(data, horarioInicio, horarioTermino, descricao, numero, idCliente)"
                            + "VALUES ( ?, ?, ?, ?, ?, ?)");
            ps.setDate(1, new java.sql.Date(sala.getData().getTime()));
            ps.setTime(2, new java.sql.Time(sala.getHorarioInicio().getTime()));
            ps.setTime(3, new java.sql.Time(sala.getHorarioTermino().getTime()));
            ps.setString(4, sala.getDescricao());
            ps.setInt(5, sala.getNumero());
            ps.setInt(6, sala.getIdCliente()); 

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

    public boolean update(Sala sala) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE sala "
                    + "SET data = ?, horarioInicio = ?, horarioTermino = ?,descricao = ?, numero = ?, idCliente = 0 "
                    + " WHERE idSala = ?");
            ps.setDate(1,new java.sql.Date(sala.getData().getTime()));
            ps.setTime(2,  new java.sql.Time(sala.getHorarioInicio().getTime()));
            ps.setTime(3, new java.sql.Time(sala.getHorarioTermino().getTime()));
            ps.setString(4, sala.getDescricao());
            ps.setInt(5, sala.getNumero());
            ps.setInt(6, sala.getId());
            ps.setInt(7, sala.getIdCliente());
 
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
                    = c.prepareStatement("DELETE FROM sala "
                            + "WHERE idSala = ?");
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

    public List<Sala> listarSala() {
        List<Sala> lista = new ArrayList<Sala>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idSala, data, horarioInicio, horarioTermino, descricao, numero, idCliente "
                            + "FROM sala");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Sala sala = new Sala();
                sala.setId(rs.getInt("idSala"));
                sala.setData(rs.getDate("data"));
                sala.setHorarioInicio(rs.getTime("horarioInicio"));
                sala.setHorarioTermino(rs.getTime("horarioTermino"));
                sala.setDescricao(rs.getString("descricao"));
                sala.setNumero(rs.getInt("numero"));
                sala.setIdCliente(rs.getInt("idCliente"));
    
                lista.add(sala);
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
    
     public List<Sala> listarSalas(String nome, int ns) {
        List<Sala> lista = new ArrayList<Sala>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idSala, data, horarioInicio, horarioTermino, descricao, numero, idCliente "
                            + " FROM sala WHERE nome LIKE ? or ns LIKE ? ");
            ps.setString(1, nome);
            ps.setInt(2, ns);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Sala sala = new Sala();
                sala.setId(rs.getInt("idSala"));
                sala.setData(rs.getDate("data"));
                sala.setHorarioInicio(rs.getTime("horarioInicio"));
                sala.setHorarioTermino(rs.getTime("horarioTermino"));
                sala.setDescricao(rs.getString("descricao"));
                sala.setNumero(rs.getInt("numero"));
                sala.setIdCliente(rs.getInt("idCliente"));

                lista.add(sala);
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

    public Sala getSalaById(int id) {
        Connection c = this.getConnection();
        Sala sala = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idSala, "
                    + "data, horarioInicio, horarioTermino, descricao, numero, idCliente "
                    + "FROM sala WHERE idSala = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                sala = new Sala();
                sala.setId(rs.getInt("idSala"));
                sala.setData(rs.getDate("data"));
                sala.setHorarioInicio(rs.getDate("horarioInicio"));
                sala.setHorarioTermino(rs.getDate("horarioTermino"));
                sala.setDescricao(rs.getString("descricao"));
                sala.setNumero(rs.getInt("numero"));
                sala.setIdCliente(rs.getInt("idCliente"));
        
            }
            rs.close();
            ps.close();
            return sala;
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

     public Sala getSalaByIdCliente(int id) {
        Connection c = this.getConnection();
        Sala sala = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idSala, "
                    + "data, horarioInicio, horarioTermino, descricao, numero, idCliente "
                    + "FROM sala WHERE idCliente = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                sala = new Sala();
                sala.setId(rs.getInt("idSala"));
                sala.setData(rs.getDate("data"));
                sala.setHorarioInicio(rs.getDate("horarioInicio"));
                sala.setHorarioTermino(rs.getDate("horarioTermino"));
                sala.setDescricao(rs.getString("descricao"));
                sala.setNumero(rs.getInt("numero"));
                sala.setIdCliente(rs.getInt("idCliente"));
        
            }
            rs.close();
            ps.close();
            return sala;
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
