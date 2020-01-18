
package Dao;

import Entity.Pagamento;
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
public class PagamentoDAO extends MySQL{
    public boolean insert(Pagamento pagamento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO pagamento "
                            + "(valor, descricao, idCliente, custoPorHora) "
                            + "VALUES ( ?, ?, ?, ?)");
            ps.setDouble(1, pagamento.getValor());
            ps.setString(2, pagamento.getDescricao());
            ps.setInt(3, pagamento.getIdCliente()); 
            ps.setDouble(4, pagamento.getCustoPorHora()); 


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

    public boolean update(Pagamento pagamento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE pagamento "
                    + "SET valor = ?, descricao = ?, idCliente = ?, custoPorHora = ? "
                    );
            ps.setDouble(1, pagamento.getValor());
            ps.setString(2, pagamento.getDescricao());
            ps.setInt(3, pagamento.getIdCliente()); 
            ps.setDouble(4, pagamento.getCustoPorHora()); 
 
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
                    = c.prepareStatement("DELETE FROM pagamento "
                            + "WHERE idPagamento = ?");
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

    public List<Pagamento> listarPagamento() {
        List<Pagamento> lista = new ArrayList<Pagamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idPagamento, valor, descricao, idCliente, custoPorHora "
                            + "FROM pagamento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setDescricao(rs.getString("descricao"));
                pagamento.setIdCliente(rs.getInt("idCliente"));
                pagamento.setCustoPorHora(rs.getDouble("custoPorHora"));
                
                lista.add(pagamento);
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
    
    public Pagamento getPagamentoById(int id) {
        Connection c = this.getConnection();
        Pagamento pagamento = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idPagamento, valor, descricao, idCliente, custoPorHora "
                    + "FROM pagamento WHERE idPagamento = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setDescricao(rs.getString("descricao"));
                pagamento.setIdCliente(rs.getInt("idCliente"));
                pagamento.setCustoPorHora(rs.getDouble("custoPorHora"));
        
            }
            rs.close();
            ps.close();
            return pagamento;
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

     public Pagamento getPagamentoByIdCliente(int id) {
        Connection c = this.getConnection();
        Pagamento pagamento = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idPagamento, valor, descricao, custoPorHora "
                    + "FROM sala WHERE idCliente = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setValor(rs.getDouble("valor"));
                pagamento.setDescricao(rs.getString("descricao"));
                pagamento.setIdCliente(rs.getInt("idCliente"));
                pagamento.setCustoPorHora(rs.getDouble("custoPorHora"));
        
            }
            rs.close();
            ps.close();
            return pagamento;
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
