/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.dal;

import br.com.reinaldo.model.Veiculo;
import br.com.reinaldo.util.PilotoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naldo
 */
public class VeiculoDal {
    private Connection conexao;
    
    public VeiculoDal(){
        conexao = PilotoUtil.getConexao();
    }
    
    public void addVeiculo(Veiculo veiculo){
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("insert into veiculos(renavam, marca, cor, placa, datanasc, categoria, combustivel, km) values (?, ?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, veiculo.getRenavam());
            preparedStatement.setString(2, veiculo.getMarca());
            preparedStatement.setString(3, veiculo.getCor());
            preparedStatement.setString(4, veiculo.getPlaca());
            preparedStatement.setDate(5, new java.sql.Date(veiculo.getDataNasc().getTime()));
            preparedStatement.setString(6, veiculo.getCategoria());
            preparedStatement.setString(7, veiculo.getCombustivel());
            preparedStatement.setInt(8, veiculo.getKm());
            preparedStatement.executeUpdate();
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteVeiculo(int veiculoId) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from veiculos where veiculoid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, veiculoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePiloto(Veiculo veiculo) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update veiculos set renavam=?, marca=?, cor=?, placa=?,"
                            + " datanasc=?, categoria=?, combustivel=?, km=?  where veiculoid=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, veiculo.getRenavam());
            preparedStatement.setString(2, veiculo.getMarca());
            preparedStatement.setString(3, veiculo.getCor());
            preparedStatement.setString(4, veiculo.getPlaca());
            preparedStatement.setDate(5, new java.sql.Date(veiculo.getDataNasc().getTime()));
            preparedStatement.setString(6, veiculo.getCategoria());
            preparedStatement.setString(7, veiculo.getCombustivel());
            preparedStatement.setInt(8, veiculo.getKm());
            preparedStatement.setInt(9, veiculo.getVeiculoId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Veiculo> getAllPilotos() {
        List<Veiculo> veiculos = new ArrayList<Veiculo>();
        
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from veiculos");
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setVeiculoId(rs.getInt("veiculoid"));
                veiculo.setRenavam(rs.getString("renavam"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setDataNasc(rs.getDate("datanasc"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setCombustivel(rs.getString("combustivel"));
                veiculo.setKm(rs.getInt("km"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculos;
    }
    
    public Veiculo getPilotosById(int veiculoId) {
        Veiculo veiculo = new Veiculo();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from veiculos where veiculoid=?");
            preparedStatement.setInt(1, veiculoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                veiculo.setVeiculoId(rs.getInt("veiculoid"));
                veiculo.setRenavam(rs.getString("renavam"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setMarca(rs.getString("placa"));
                veiculo.setDataNasc(rs.getDate("datanasc"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setCombustivel(rs.getString("combustivel"));
                veiculo.setKm(rs.getInt("km"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return veiculo;
    }
}
