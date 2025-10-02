package Task7.src;

import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(String name, String department, double salary) {
        String sql = "INSERT INTO employees(name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();

            System.out.println(" Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String department, double salary) {
        String sql = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, department);
            stmt.setDouble(2, salary);
            stmt.setInt(3, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println(" Employee updated!");
            else System.out.println(" Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) System.out.println(" Employee deleted!");
            else System.out.println(" Employee not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

