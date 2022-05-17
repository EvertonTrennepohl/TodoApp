package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save(Project project) {
		String sql = "INSERT INTO projetos (nome, descricao, data_criacao, "
				+ "data_atualizacao) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdateAt().getTime()));
			statement.execute();
		} catch (Exception ex) {
			System.out.println("Erro ao salvar o projeto!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public void update(Project project) {
		String sql = "UPDATE projetos set nome = ?, descricao = ?, data_criacao = ?, "
				+ "data_atualizacao = ? WHERE id_projeto = ?";
		Connection conn = null;;
		PreparedStatement statement = null;;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdateAt().getTime()));
			statement.setInt(5, project.getId());
			statement.execute();
		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar o projeto!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public void removeById(int idProject) {
		String sql = "DELETE FROM projetos WHERE id_projeto = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, idProject);
			statement.execute();
		} catch (SQLException ex) {
			System.out.println("Erro ao deletar o projeto!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public List<Project> getAll() {
		String sql = "SELECT * FROM projetos";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Project project = new Project(resultSet.getInt("id_projeto"), 
						resultSet.getString("nome"),
						resultSet.getString("descricao"),
						resultSet.getDate("data_criacao"),
						resultSet.getDate("data_atualizacao"));
				projects.add(project);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao carregar os projetos!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement, resultSet);
		}
		return projects;
	}
}
