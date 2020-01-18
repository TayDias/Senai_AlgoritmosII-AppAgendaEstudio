
package Dao;

import Entity.Disco;
import Entity.EnumGenero;
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
public class DiscoDAO extends MySQL{
    public boolean insert(Disco disco) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO disco "
                            + "(Nome, Artista, Genero, Duracao, Faixas) "
                            + "VALUES ( ?, ?, ?, ?, ?)");
            ps.setString(1, disco.getNome());
            ps.setString(2, disco.getArtista());
            ps.setInt(3, disco.getGenero().getCodigo());
            ps.setString(4, disco.getDuracao());
            ps.setInt(5, disco.getFaixas());
   
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

    public boolean update(Disco disco) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE disco "
                    + "SET nome = ?, Artista = ?, Genero = ?,Duracao= ?, Faixas = ?"
                    + " WHERE idDisco = ?");
            ps.setString(1, disco.getNome());
            ps.setString(2, disco.getArtista());
            ps.setInt(3, disco.getGenero().getCodigo());
            ps.setString(4, disco.getDuracao());
            ps.setInt(5, disco.getFaixas());
            ps.setInt(6, disco.getId());

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
    
    public List<Disco> listarDiscos() {
        List<Disco> lista = new ArrayList<Disco>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idDisco, Nome, Artista, Genero, Duracao, Faixas "
                            + "FROM disco ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Disco disco = new Disco();
                disco.setId(rs.getInt("idDisco"));
                disco.setNome(rs.getString("nome"));
                disco.setArtista(rs.getString("artista"));
                disco.setGenero(EnumGenero.POP.getGenero(rs.getInt("genero")));
                disco.setDuracao(rs.getString("duracao"));
                disco.setFaixas(rs.getInt("faixas"));
                
                lista.add(disco);
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

    public List<Disco> listarDiscos(String nome) {
        List<Disco> lista = new ArrayList<Disco>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idDisco, Nome, Artista, Genero, Duracao, Faixas"
                            + "FROM disco WHERE nome LIKE ? ");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Disco disco = new Disco();
                disco.setId(rs.getInt("idDisco"));
                disco.setNome(rs.getString("nome"));
                disco.setArtista(rs.getString("artista"));
                disco.setGenero(EnumGenero.POP.getGenero(rs.getInt("genero")));
                disco.setDuracao(rs.getString("duracao"));
                disco.setFaixas(rs.getInt("faixas"));
                
                lista.add(disco);
               
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
    
    public Disco getDiscosById(int id) {
        Connection c = this.getConnection();
        Disco disco = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idDisco, "
                    + "Nome, Artista, Genero, Duracao, Faixas "
                    + "FROM disco WHERE idDisco = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                disco = new Disco();
                disco.setId(rs.getInt("idDisco"));
                disco.setNome(rs.getString("nome"));
                disco.setArtista(rs.getString("artista"));            
                disco.setGenero(EnumGenero.POP.getGenero(rs.getInt("genero")));
                disco.setDuracao(rs.getString("duracao"));
                disco.setFaixas(rs.getInt("faixas"));
   
            }
            rs.close();
            ps.close();
            return disco;
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
