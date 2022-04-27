package com.example.achievav2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class ConnectSignUp {
    class Async extends AsyncTask<String, Void, Boolean> {


        String records = "";
        String error = "";

        @Override

        protected Boolean doInBackground(String... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");
                String fullname = "\"" + voids[0]+"\"";
                String email = "\"" + voids[1]+"\"";
                String username = "\"" + voids[2]+"\"";
                String password = "\"" + voids[3]+"\"";
                //               String query = "SELECT Id FROM Users WHERE Username = ?";
                //               Statement statement = connection.prepareStatement(query);
                //               ((PreparedStatement) statement).setString(1, voids[0]);
                //               ResultSet resultSet = statement.executeQuery();
             //   Statement statement = connection.createStatement();
                String query = "INSERT INTO Users (Fullname, Email, Username, Password) "
                        + "VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, fullname);
                preparedStmt.setString (2, email);
                preparedStmt.setString (3, username);
                preparedStmt.setString (4, password);
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

