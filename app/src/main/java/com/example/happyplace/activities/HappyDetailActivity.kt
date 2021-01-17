package com.example.happyplace.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.happyplace.R
import com.example.happyplace.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_happy_detail.*

class HappyDetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_ACTIVITY = "DETAIL_ACTIVITY"
    }

    private var happpyPlaceDetailModel: HappyPlaceModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_detail)

        happpyPlaceDetailModel =
            intent.getParcelableExtra(DETAIL_ACTIVITY)

        happpyPlaceDetailModel?.let {
            setSupportActionBar(toolbar_detail_place)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = it.title

            toolbar_detail_place.setNavigationOnClickListener{
                onBackPressed()
            }

            iv_place_image.setImageURI(Uri.parse(it.image))
            tv_description.text = it.description
            tv_location.text = it.location

            btn_view_on_map.setOnClickListener{
                val intent = Intent(this, GoogleMapActivity::class.java)
                intent.putExtra(MainActivity.EXTRA_PLACE_DETAIL, happpyPlaceDetailModel)
                startActivity(intent)
            }

        }
    }
}