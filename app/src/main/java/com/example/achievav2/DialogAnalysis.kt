package com.example.achievav2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class DialogAnalysis constructor(message: String): AppCompatDialogFragment() {

    //false flag -> unhealthy
    //true flag -> healthy

    private var message: String = message

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(activity)
        builder.setTitle("Analysis").setMessage(message).setPositiveButton("Ok") { p0, p1 ->
            //don't do anything when "Ok" is pressed. The dialog will close on its own.
        }

        return builder.create()
    }
}