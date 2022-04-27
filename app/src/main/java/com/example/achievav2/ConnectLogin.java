package com.example.achievav2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectLogin {
    class Async extends AsyncTask<String, Void, Boolean> {


        String records = "";
        String error = "";

        @Override

        protected Boolean doInBackground(String... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");

                String username = "\"%" + voids[0]+"%\"";
                String password = "\"%" + voids[1]+"%\"";
                //               String query = "SELECT Id FROM Users WHERE Username = ?";
                //               Statement statement = connection.prepareStatement(query);
                //               ((PreparedStatement) statement).setString(1, voids[0]);
                //               ResultSet resultSet = statement.executeQuery();
                   Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE Username LIKE " + username + " AND Password LIKE " + password);
                    while (resultSet.next()) {
                      records += resultSet.getString("Username");// + " " + resultSet.getString(2) + "\n";
                        Log.d("myTagTRYHERE", records);
                    }

                Log.d("myTagOKKKKK", String.valueOf(resultSet));
                statement.close();
            } catch (Exception e) {
                Log.d("myTag", String.valueOf(e));
                error = e.toString();
                return false;
            }
            if(records == "")
                return false;
            else
                return true;

        }

//        @Override
//        protected void onPostExecute(String records) {
//            super.onPostExecute(records);
//            Log.d("myTag", "Test PostExec");

//        }
    }
}
