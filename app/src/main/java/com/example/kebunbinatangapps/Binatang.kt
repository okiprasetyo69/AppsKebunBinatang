package com.example.kebunbinatangapps

class Binatang {
    var nama : String ?= null
    var deskripsi : String ?= null
    var gambar : Int ?= null
    var binatangBuas : Boolean ?= null
    constructor(nama: String, dsc: String, gambar: Int, buas: Boolean){
        this.nama = nama
        this.deskripsi = dsc
        this.gambar = gambar
        this.binatangBuas = buas
    }
}