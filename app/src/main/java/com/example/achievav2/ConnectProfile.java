package com.example.achievav2;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectProfile {
    class Async extends AsyncTask<String, Void, String[]> {


        String[] records = new String[5];
        String error = "";

        @Override

        protected String[] doInBackground(String... voids) {

            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://achievafinal.c8sq49drsyar.us-east-1.rds.amazonaws.com:3306/ACHIEVA", "admin", "TjX6c5wtsOUg");

                String id = "\"%" + voids[0] + "%\"";
                Integer ID = Integer.parseInt(voids[0]);
                //               String query = "SELECT Id FROM Users WHERE Username = ?";
                //               Statement statement = connection.prepareStatement(query);
                //               ((PreparedStatement) statement).setString(1, voids[0]);
                //               ResultSet resultSet = statement.executeQuery();
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT Id, Username, Weight, Sex, Feet, Inch FROM Users WHERE Id = " + ID);
             //   int i = 0;
                while (resultSet.next()) {
                    records[0] = resultSet.getString("Username");// + " " + resultSet.getString(2) + "\n";
                    records[1] = resultSet.getString("Weight");
                    records[2] = resultSet.getString("Sex");
                    records[3] = resultSet.getString("Feet");
                    records[4] = resultSet.getString("Inch");
                    //    Log.d("myTagUSERID", String.valueOf(records[0]));

                }

             //   Log.d("myTagOKITWORKED", String.valueOf(records[0]));
                statement.close();
            } catch (Exception e) {
             //   Log.d("myTagERROR", String.valueOf(e));
                error = e.toString();
                if (records[0] == null)
                    records[0] = "";
                if (records[1] == null)
                    records[1] = "";
                if (records[2] == null)
                    records[2] = "";
                if (records[3] == null)
                    records[3] = "";
                if (records[4] == null)
                    records[4] = "";
                return records;
            }
            if (records[0] == null)
                records[0] = "";
            if (records[1] == null)
                records[1] = "";
            if (records[2] == null)
                records[2] = "";
            if (records[3] == null)
                records[3] = "";
            if (records[4] == null)
                records[4] = "";
            return records;
        //    else
        //        return records;

        }

//        @Override
//        protected void onPostExecute(String records) {
//            super.onPostExecute(records);
//            Log.d("myTag", "Test PostExec");

//        }
    }
}