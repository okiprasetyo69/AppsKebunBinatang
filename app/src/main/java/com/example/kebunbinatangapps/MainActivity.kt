package com.example.kebunbinatangapps

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_binatang_buas.view.*

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter : AdapterBinatang ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBinatang.add(
            Binatang("Jerapah", "Jerapah Keren", R.drawable.jerapah, false)
        )
        listBinatang.add(
            Binatang("Ular Kobra", "Kobra Beracun", R.drawable.kobra, true)
        )
        listBinatang.add(
            Binatang("Kuda", "Kuda koboy", R.drawable.kuda, false)
        )
        listBinatang.add(
            Binatang("Harimau", "Harimau Kalimantan", R.drawable.macan, true)
        )
        listBinatang.add(
            Binatang("Monyet", "Monyet ketawa", R.drawable.monyet, false)
        )
        listBinatang.add(
            Binatang("Rusa", "Rusa Ciwidey", R.drawable.rusa, false)
        )
        listBinatang.add(
            Binatang("Singa", "Singa Jabrig", R.drawable.singa, true)
        )
        listBinatang.add(
            Binatang("Unta", "Unta Arab", R.drawable.unta, false)
        )
        listBinatang.add(
            Binatang("Gajah", "Gajah Badag", R.drawable.gajah, false)
        )
        listBinatang.add(
            Binatang("Garuda", "Garuda Pancasila", R.drawable.garuda, false)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter
    }

    inner class AdapterBinatang : BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context : Context ?= null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>) : super(){
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p3: ViewGroup?) : View{
            val binatang = listBinatang[p0]
            if(binatang.binatangBuas == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang_buas, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDsc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)
                myView.imgGambarBinatang.setOnClickListener(){

                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                val binatang = listBinatang[p0]
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.item_list_binatang, null )
                myView.txtNama.text = binatang.nama!!
                myView.txtDsc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)
                myView.imgGambarBinatang.setOnClickListener {

                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any{
            return listBinatang[p0]
        }

        override fun getItemId(p0: Int): Long{
            return p0.toLong()
        }
        override fun getCount() : Int{
            return listBinatang.size
        }
    }

}



