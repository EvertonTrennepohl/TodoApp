package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {

	public void save(Task task) {
		String sql = "INSERT INTO tarefas (id_Projeto, "
				+ "nome, descricao, status, observacoes, prazo, "
				+ "data_criacao, data_atualizacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7,  new Date(task.getCreatedAt().getTime()));
			statement.setDate(8,  new Date(task.getUpdateAt().getTime()));
			statement.execute();
			
		} catch (SQLException ex) {
			System.out.println("Erro ao salvar a tarefa!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public void update(Task task) {
		String sql = "UPDATE tarefas set id_Projeto = ?, nome = ?, descricao = ?, status = ?, "
				+ "observacoes = ?, prazo = ?, data_criacao = ?, data_atualizacao = ? "
				+ "WHERE id_tarefa = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7,  new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdateAt().getTime()));
			statement.setInt(9, task.getId());
			statement.execute();
		} catch (SQLException ex) {
			System.out.println("Erro ao atualizar a tarefa!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public void removeById(int taskId) {
		String sql = "DELETE FROM tarefas WHERE id_tarefa = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.execute();
		} catch (SQLException ex) {
			System.out.println("Erro ao deletar a tarefa!");
			ex.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(conn, statement);
		}
	}
	
	public List<Task> getAll(int idProject) {
		String sql = "SELECT * FROM tarefas WHERE id_Projeto = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Task> tasks = new ArrayList<Task>();
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);			
			statement.setInt(1, idProject);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {				
				Task task = new Task();
				task.setId(resultSet.getInt("id_Tarefa"));
				task.setIdProject(resultSet.getInt("id_Projeto"));
				task.setName(resultSet.getString("nome"));
				task.setDescription(resultSet.getString("descricao"));
				task.setCompleted(resultSet.getBoolean("status"));
				task.setNotes(resultSet.getString("observacoes"));
				task.setDeadline(resultSet.getDate("prazo"));
				task.setCreatedAt(resultSet.getDate("data_criacao"));
				task.setUpdateAt(resultSet.getDate("data_atualizacao"));
				tasks.add(task);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao carregar as tarefas!" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, statement, resultSet);
		}		
		return tasks;
	}
}
