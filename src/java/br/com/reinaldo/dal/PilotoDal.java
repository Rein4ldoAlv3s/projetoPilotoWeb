/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.dal;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.reinaldo.model.Piloto;
import br.com.reinaldo.util.PilotoUtil;

/**
 *
 * @author naldo
 */
public class PilotoDal {

    private Connection conexao;
    
    public PilotoDal(){
        conexao = PilotoUtil.getConexao();
    }
    
    public void addPiloto(Piloto piloto){
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("insert into pilotos(matricula, nome, pais, datanasc, equipe, fabricmotor, pontostemp) values (?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setInt(1, piloto.getMatricula());
            preparedStatement.setString(2, piloto.getNome());
            preparedStatement.setString(3, piloto.getPais());
            preparedStatement.setDate(4, new java.sql.Date(piloto.getDataNasc().getTime()));
            preparedStatement.setString(5, piloto.getEquipe());
            preparedStatement.setString(6, piloto.getFabricMotor());
            preparedStatement.setInt(7, piloto.getPontosTemp());
            preparedStatement.executeUpdate();
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePiloto(int pilotoId) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from pilotos where pilotoId=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pilotoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePiloto(Piloto piloto) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pilotos set matricula=?, nome=?, pais=?, datanasc=?, equipe=?, fabricmotor=?, pontostemp=?  where pilotoid=?");
            // Parameters start with 1
            
            preparedStatement.setInt(1, piloto.getMatricula());
            preparedStatement.setString(2, piloto.getNome());
            preparedStatement.setString(3, piloto.getPais());
            preparedStatement.setDate(4, new java.sql.Date(piloto.getDataNasc().getTime()));
            preparedStatement.setString(5, piloto.getEquipe());
            preparedStatement.setString(6, piloto.getFabricMotor());
            preparedStatement.setInt(7, piloto.getPontosTemp());
            preparedStatement.setInt(8, piloto.getPilotoId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Piloto> getAllPilotos() {
        List<Piloto> pilotos = new ArrayList<Piloto>();
        
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from pilotos");
            while (rs.next()) {
                Piloto piloto = new Piloto();
                piloto.setPilotoId(rs.getInt("pilotoid"));
                piloto.setMatricula(rs.getInt("matricula"));
                piloto.setNome(rs.getString("nome"));
                piloto.setPais(rs.getString("pais"));
                piloto.setDataNasc(rs.getDate("datanasc"));
                piloto.setEquipe(rs.getString("equipe"));
                piloto.setFabricMotor(rs.getString("fabricmotor"));
                piloto.setPontosTemp(rs.getInt("pontostemp"));
                pilotos.add(piloto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pilotos;
    }
    public Piloto getPilotosById(int pilotoId) {
        Piloto piloto = new Piloto();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from pilotos where pilotoid=?");
            preparedStatement.setInt(1, pilotoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                piloto.setPilotoId(rs.getInt("pilotoid"));
                piloto.setMatricula(rs.getInt("matricula"));
                piloto.setNome(rs.getString("nome"));
                piloto.setPais(rs.getString("pais"));
                piloto.setDataNasc(rs.getDate("datanasc"));
                piloto.setEquipe(rs.getString("equipe"));
                piloto.setFabricMotor(rs.getString("fabricmotor"));
                piloto.setPontosTemp(rs.getInt("pontostemp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return piloto;
    }
}
