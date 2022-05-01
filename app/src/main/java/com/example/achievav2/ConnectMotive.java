package com.example.achievav2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class ConnectMotive {
    class Async extends AsyncTask<Integer, Void, Boolean> {


        String records = "";
        String error = "";

        @Override

        protected Boolean doInBackground(Integer... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");
                Integer IdInt = voids[0];
                Integer m1 = voids[1];
                Integer m2 = voids[2];
                Integer m3 = voids[3];
                Integer m4 = voids[4];
                Integer m5 = voids[5];
                Integer m6 = voids[6];
                Integer m7 = voids[7];
                //               String query = "SELECT Id FROM Users WHERE Username = ?";
                //               Statement statement = connection.prepareStatement(query);
                //               ((PreparedStatement) statement).setString(1, voids[0]);
                //               ResultSet resultSet = statement.executeQuery();
                //   Statement statement = connection.createStatement();
                String query = "INSERT INTO Motives (Id, MQ1, MQ2, MQ3, MQ4, MQ5, MQ6, MQ7) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setInt (1, IdInt);
                preparedStmt.setInt (2, m1);
                preparedStmt.setInt (3, m2);
                preparedStmt.setInt (4, m3);
                preparedStmt.setInt (5, m4);
                preparedStmt.setInt (6, m5);
                preparedStmt.setInt (7, m6);
                preparedStmt.setInt (8, m7);
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
                try {

                    Class.forName("com.mysql.jdbc.Driver");

                    Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");
                    Integer IdInt = voids[0];
                    Integer m1 = voids[1];
                    Integer m2 = voids[2];
                    Integer m3 = voids[3];
                    Integer m4 = voids[4];
                    Integer m5 = voids[5];
                    Integer m6 = voids[6];
                    Integer m7 = voids[7];
                String query = "UPDATE Motives SET MQ1 = ?, MQ2 = ?, MQ3 = ?, MQ4 = ?, MQ5 = ?, MQ6 = ?, MQ7 = ? WHERE Id = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setInt (8, IdInt);
                    preparedStmt.setInt (1, m1);
                    preparedStmt.setInt (2, m2);
                    preparedStmt.setInt (3, m3);
                    preparedStmt.setInt (4, m4);
                    preparedStmt.setInt (5, m5);
                    preparedStmt.setInt (6, m6);
                    preparedStmt.setInt (7, m7);
                preparedStmt.execute();

                    preparedStmt.close();
                } catch (Exception err) {
                    Log.d("myTag", String.valueOf(e));
                    error = e.toString();
                }
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

