/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class notebad {

    int code;
    String name;
    String data;
    String date;
    String fontcolor;
    String fontstyle;
    String pos;
    String backgroundcolor;
    ArrayList<notebad> datas = new ArrayList<>();

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    public String getName() {
        return name;
    }

    public String getBold() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDatas(ArrayList<notebad> datas) {
        this.datas = datas;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFontcolor(String fontcolor) {
        this.fontcolor = fontcolor;
    }

    public void setFontstyle(String fontstyle) {
        this.fontstyle = fontstyle;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }

    public ArrayList<notebad> getDatas() {
        return datas;
    }

    public String getDate() {
        return date;
    }

    public String getFontcolor() {
        return fontcolor;
    }

    public String getFontstyle() {
        return fontstyle;
    }

    public String getPos() {
        return pos;
    }

    void load() {
        for (int i = datas.size() - 1; i >= 0; i--) {
            datas.remove(i);
        }
        Statement stmt;
        try {
            Connection con = DatabaseConnection.getconnection();
            stmt = con.createStatement();
            String query = "SELECT * FROM notebad";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                notebad thiss = new notebad();
                thiss.setBackgroundcolor(res.getString("backgroundcolor"));
                thiss.setCode(res.getInt("code"));
                thiss.setData(res.getString("data"));
                thiss.setDate(res.getString("date"));
                thiss.setFontcolor(res.getString("fontcolor"));
                thiss.setFontstyle(res.getString("fontstyle"));
                thiss.setName(res.getString("name"));
                thiss.setPos(res.getString("pos"));
                datas.add(thiss);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(notebad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int search(int code) {
        load();
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    long insert(String name, String data, String date, String fontcolor, String fontstyle, String pos, String backgroundcolor) {
        load();
        long max = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).getCode() > max) {
                max = datas.get(i).getCode();
            }
        }
        max++;
        Statement stmt;
        try {
            Connection con = DatabaseConnection.getconnection();
            stmt = con.createStatement();
            String query = "INSERT INTO notebad VALUES('" + max + "','" + name + "','" + data + "','" + date + "','" + fontcolor + "','" + fontstyle + "','" + pos + "','" + backgroundcolor + "')";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(notebad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }

    void update(int code, String name, String data, String date, String fontcolor, String fontstyle, String pos, String backgroundcolor) {
        Statement stmt;
        try {
            Connection con = DatabaseConnection.getconnection();
            stmt = con.createStatement();
            String query = "UPDATE notebad SET  code='" + code + "',name='" + name + "',data='" + data + "',date='" + date + "',fontcolor='" + fontcolor + "',fontstyle='" + fontstyle + "',pos='" + pos + "',backgroundcolor='" + backgroundcolor + "' WHERE code='" + code + "'";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(notebad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int delet(String code) {
        Statement stmt;
        try {
            Connection con = DatabaseConnection.getconnection();
            stmt = con.createStatement();
            String query = "DELETE FROM notebad WHERE code='" + code + "'";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(notebad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

}
