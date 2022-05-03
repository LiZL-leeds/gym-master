package project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.bean.Mer;
import project.util.DBUtil;

public class MerDAO {
    //总用户个数
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from Mer";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Mer bean) {

        String sql = "insert into user values(null, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getEmail());
            ps.setString(4, bean.getPlacename());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Mer bean) {

        String sql = "update user set name= ? ,password = ?, email = ?, placename = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getEmail());
            ps.setString(4, bean.getPlacename());
            ps.setInt(5, bean.getId());

            ps.execute();
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from Mer where id = " + id;

            s.execute(sql);
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Mer get(int id) {
        Mer bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from Mer where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Mer();
                bean.setId(id);
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
                bean.setPlacename(rs.getString("placename"));

            }
            c.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Mer> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Mer> list(int start, int count) {
        List<Mer> beans = new ArrayList<Mer>();

        String sql = "select * from Mer order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mer bean = new Mer();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
                bean.setPlacename(rs.getString("placename"));


                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean isExist(String name) {
        Mer mer = get(name);
        return mer!=null;

    }

    public Mer get(String name) {
        Mer bean = null;

        String sql = "select * from Mer where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Mer();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
                bean.setPlacename(rs.getString("placename"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public Mer get(String name, String password) {
        Mer bean = null;

        String sql = "select * from Mer where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Mer();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setPassword(rs.getString("password"));
                bean.setEmail(rs.getString("email"));
                bean.setPlacename(rs.getString("placename"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }


}
