
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entity.Cliente;


public class ClienteDAO extends MySQL{
     public boolean insert(Cliente cliente) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO cliente "
                            + "(Nome, CPF, RG,TelCelular, TelResidencial, Rua, Numero, Bairro, Cidade,"
                            + " Estado, CEP)  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getRG());
            ps.setString(4, cliente.getTelCelular());
            ps.setString(5, cliente.getTelResidencial());
            ps.setString(6, cliente.getRua());
            ps.setInt(7, cliente.getNumero());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getEstado());
            ps.setString(11, cliente.getCEP());
            
            
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

    public boolean update(Cliente cliente) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE cliente "
                    + "SET nome = ?, CPF = ?, RG = ?,TelCelular = ?, TelResidencial = ?, Rua = ?, "
                    + "Numero = ?, Bairro = ?, Cidade = ?, Estado = ?, CEP = ?"
                    + " WHERE idCliente = ?");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getRG());
            ps.setString(4, cliente.getTelCelular());
            ps.setString(5, cliente.getTelResidencial());
            ps.setString(6, cliente.getRua());
            ps.setInt(7, cliente.getNumero());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getEstado());
            ps.setString(11, cliente.getCEP());
            ps.setInt(12, cliente.getId());

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
                    = c.prepareStatement("DELETE FROM cliente "
                            + "WHERE idCliente = ?");
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

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<Cliente>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idCliente, nome, CPF, RG,TelCelular, TelResidencial, Rua,"
                            + " Numero, Bairro, Cidade, Estado, CEP"
                            + " FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setRG(rs.getString("rg"));
                cliente.setTelCelular(rs.getString("telCelular"));
                cliente.setTelResidencial(rs.getString("telResidencial"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCEP(rs.getString("cep"));
                

                lista.add(cliente);
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

    public List<Cliente> listarClientes(String nome) {
        List<Cliente> lista = new ArrayList<Cliente>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT idCliente, nome, CPF, RG,TelCelular, TelResidencial, Rua,"
                            + " Numero, Bairro, Cidade, Estado, CEP"
                            + " FROM cliente WHERE nome LIKE ? ");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setRG(rs.getString("rg"));
                cliente.setTelCelular(rs.getString("telCelular"));
                cliente.setTelResidencial(rs.getString("telResidencial"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCEP(rs.getString("cep"));
                

                lista.add(cliente);
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
    
    public Cliente getClienteById(int id) {
        Connection c = this.getConnection();
        Cliente cliente = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idCliente, "
                    + "nome, CPF, RG,TelCelular, TelResidencial, Rua,"
                            + " Numero, Bairro, Cidade, Estado, CEP "
                    + "FROM cliente WHERE idCliente = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setRG(rs.getString("rg"));
                cliente.setTelCelular(rs.getString("telCelular"));
                cliente.setTelResidencial(rs.getString("telResidencial"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCEP(rs.getString("cep"));
            }
            rs.close();
            ps.close();
            return cliente;
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
