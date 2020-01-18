/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entity.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Taynara
 */
public class HistoricoDAO extends MySQL{
     public boolean insert(Historico historico) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO historico "
                            + "(Data, Hora, Custo  "
                            + "VALUES ( ?, ?, ?)");
            ps.setString(1, historico.getData());
            ps.setString(2, historico.getHora());
            ps.setString(3, historico.getCusto()+"");
            
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
}
