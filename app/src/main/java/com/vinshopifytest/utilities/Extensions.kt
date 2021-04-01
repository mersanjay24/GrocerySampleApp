package com.vinshopifytest.utilities

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.vinshopifytest.R

var progressDialog: AppCompatDialog? = null

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun progressON(activity: Activity?) {
    progressON(activity, "Loading")
}

fun progressON(activity: Activity?, message: String?) {
    if (activity == null || activity.isFinishing) {
        return
    }
    if (progressDialog != null && progressDialog!!.isShowing) {
        //progressSET(message)
    } else {
        progressDialog = AppCompatDialog(activity)
        progressDialog!!.setCancelable(false)
        progressDialog!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog!!.setContentView(R.layout.progress_bar)
        progressDialog!!.show()
    }
}

fun progressOFF() {
    if (progressDialog != null && progressDialog!!.isShowing) {
        progressDialog!!.dismiss()
    }
}
