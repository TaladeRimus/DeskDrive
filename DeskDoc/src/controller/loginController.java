package controller;
import interfaces.loginInterface;

import java.sql.*;

import javax.swing.JOptionPane;

import view.DeskDoc;

public class loginController implements loginInterface {
	
	String username;
	String password;
	Connection con = null;
	
/*	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		loginController l = new loginController();
		//l.registro("user", "teste");
		l.login("user", "teste");
	}*/
	
	
	public void connect() throws ClassNotFoundException, SQLException{
		try {
			
			Class.forName("org.postgresql.Driver");
			
		} catch (Exception e) {
			System.err.println("Classe drive não encontrada");
			e.printStackTrace();
		}
		
		String databaseUser = "postgres";
		String databasePass = "123";
		
		try {
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DeskDrive", databaseUser, databasePass);
			
		} catch (Exception e) {
			System.err.println("Não foi possível conectar, tente novamente");
			e.printStackTrace();
		}		
		
	}

	@Override
	public void registro(String username, String password) {
		
		try {
			
			this.username = username;
			this.password = password;
			connect();
			
			PreparedStatement stm = con.prepareStatement("SELECT * FROM users WHERE username = ?");
			stm.setString(1, username);
			ResultSet rst = stm.executeQuery();
			
			if( rst.next() ){
				JOptionPane.showMessageDialog(null, "Usuário já cadastrado no sistema");
			} else {
				
				PreparedStatement st = con.prepareStatement("INSERT INTO users (username, password, idGroupFK) VALUES (?, ?, 2)");
				st.setString(1, username);
				st.setString(2, password);
				st.execute();
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");		
				
			}			
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão com o banco de dados");
			e.printStackTrace();
		}
	
		
	}

	@Override
	public int login(String username, String password) {
		
		
		try {
			
			this.username = username;
			this.password = password;
			connect();
			
			PreparedStatement st = con.prepareStatement("SELECT idGroupFK FROM users WHERE username = ? AND password = ?");
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			
			if ( rs.next() ) {
				
				if ( rs.getInt(1) == 1) {
				
					JOptionPane.showMessageDialog(null, "Seja bem-vindo, Administrador");
					return 1;
				}
				
				else if( rs.getInt(1) == 2 ) {
					
					JOptionPane.showMessageDialog(null, "Seja bem-vindo ao DeskDrive");
					return 2;
				}
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
				
			}
		
		
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível localizar o banco de dados ou sua classe");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	

}
