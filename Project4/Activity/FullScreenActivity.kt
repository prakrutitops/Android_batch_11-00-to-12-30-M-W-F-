package com.example.firstapp.Activity

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.DownloadManager
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityCategoryBinding
import com.example.firstapp.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.ByteArrayOutputStream
import java.lang.Exception

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var url = i.getStringExtra("f_pos")


        Picasso.get().load(url).into(binding.photo)

        if (checkSelfPermission(READ_EXTERNAL_STORAGE) != PERMISSION_GRANTED && checkSelfPermission(
                WRITE_EXTERNAL_STORAGE
            ) != PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE),
                101
            )
        }

        binding.btndownload.setOnClickListener {


            var manager: DownloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            var uri = Uri.parse(url)
            var request: DownloadManager.Request = DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            manager.enqueue(request)
            Toast.makeText(applicationContext, "Downloading start", Toast.LENGTH_LONG).show()
        }
        binding.btnshare.setOnClickListener {

            Picasso.get().load(url).into(object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    shareprepareintent(bitmap!!)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }
            })
        }


    }

    private fun shareprepareintent(bitmap: Bitmap) {
        val shareIntent = Intent()
        shareIntent.setAction(Intent.ACTION_SEND)
        shareIntent.putExtra(Intent.EXTRA_STREAM, getImageUri(this, bitmap))
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Hey there" + "https://play.google.com/store/apps/details?id=tops.technologies.topscarrercenter"
        )
        shareIntent.setType("image/*")
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(shareIntent, "Share Opportunity"))

    }

    private fun getImageUri(fullScreenActivity: FullScreenActivity, bitmap: Bitmap): Uri? {

        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path: String = MediaStore.Images.Media.insertImage(
            fullScreenActivity.contentResolver,
            bitmap,
            "Greetings",
            null
        )
        return Uri.parse(path)

    }


}