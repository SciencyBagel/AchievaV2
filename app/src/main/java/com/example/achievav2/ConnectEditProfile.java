package com.example.achievav2;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class ConnectEditProfile {
    class Async extends AsyncTask<String, Void, Boolean> {


        String records = "";
        String error = "";

        @Override

        protected Boolean doInBackground(String... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");
                Integer ID = Integer.parseInt(voids[0]);
                String username = "\"" + voids[1]+"\"";
//                String feet = "\"" + voids[2]+"\"";
//                String inch = "\"" + voids[3]+"\"";
//                String weight = "\"" + voids[4]+"\"";
                Integer feet = Integer.parseInt(voids[2]);
                Integer inch = Integer.parseInt(voids[3]);
                Integer weight = Integer.parseInt(voids[4]);
                Integer sex = Integer.parseInt(voids[5]);
                String query = "UPDATE Users SET Username = ?, Feet = ?, Inch = ?, Weight = ?, Sex = ? WHERE Id = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, username);
                preparedStmt.setInt (2, feet);
                preparedStmt.setInt (3, inch);
                preparedStmt.setInt (4, weight);
                preparedStmt.setInt (5, sex);
                preparedStmt.setInt (6, ID);
                preparedStmt.execute();
                //    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE Username = "+user + " AND Password = "+password);
                //    while (resultSet.next()) {

                //      records += resultSet.getString(1) + "\n";// + " " + resultSet.getString(2) + "\n";

                //    }
                Log.d("myTagOKKKKK", voids[1]);
                preparedStmt.close();
            } catch (Exception e) {
                Log.d("myTag", String.valueOf(e));
                error = e.toString();
                return false;
            }

            return true;

        }

//        @Override
//        protected void onPostExecute(String records) {
//            super.onPostExecute(records);
//            Log.d("myTag", "Test PostExec");

//        }
    }

}


