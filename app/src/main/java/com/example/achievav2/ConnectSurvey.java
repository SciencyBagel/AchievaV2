package com.example.achievav2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class ConnectSurvey{
    class Async extends AsyncTask<Integer, Void, Boolean> {


        String records = "";
        String error = "";

        @Override

        protected Boolean doInBackground(Integer... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");
                Integer Id = voids[0];
                Integer a1 = voids[1];
                Integer a2 = voids[2];
                Integer a3 = voids[3];
                Integer a4 = voids[4];
                Integer a5 = voids[5];
                Integer a6 = voids[6];
                Integer a7 = voids[7];
                Integer a8 = voids[8];
                Integer a9 = voids[9];

                //               String query = "SELECT Id FROM Users WHERE Username = ?";
                //               Statement statement = connection.prepareStatement(query);
                //               ((PreparedStatement) statement).setString(1, voids[0]);
                //               ResultSet resultSet = statement.executeQuery();
                //   Statement statement = connection.createStatement();
                String query = "INSERT INTO Surveys (Id, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt (1, Id);
                preparedStmt.setInt (2, a1);
                preparedStmt.setInt (3, a2);
                preparedStmt.setInt (4, a3);
                preparedStmt.setInt (5, a4);
                preparedStmt.setInt (6, a5);
                preparedStmt.setInt (7, a6);
                preparedStmt.setInt (8, a7);
                preparedStmt.setInt (9, a8);
                preparedStmt.setInt (10, a9);
                preparedStmt.execute();
                //    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE Username = "+user + " AND Password = "+password);
                //    while (resultSet.next()) {

                //      records += resultSet.getString(1) + "\n";// + " " + resultSet.getString(2) + "\n";

                //    }
                Log.d("myTagOKKKKK", voids[1].toString());
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

