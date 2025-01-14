package com.mustafaaktas.my_application2

import android.graphics.Paint.Join
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Job

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //KİLO TAKİP UYGULAMASI
        println("--------------Kilo Takip Uygulaması----------")
        fun main(){
            val KiloTakip = HashMap<String, Double>()

            while (true){
                println("\n--- Kilo Takip Uygulaması ---")
                println("1. Kullanıcı Ekle")
                println("2. Kullanıcı Kilosunu Güncelle")
                println("3. Kullanıcı Kilosunu Göster")
                println("4. Tüm Kullanıcıları Göster")
                println("5. Çıkış")
                println("Seçiminiz: ")

                when (readLine()?.toIntOrNull()) {
                    1 -> {
                      println("Kullanıcı Adı:")
                        val ad = readLine()
                        if (ad != null && ad.isNotBlank()){
                            println("$ad kullanıcısının Kilosu:")
                            val kilo = readLine()?.toDoubleOrNull()
                            if (kilo!= null && kilo > 0) {
                                KiloTakip[ad] = kilo
                                println("$ad başarıyla eklendi.")

                                 }else {
                                     println("Geçerli bir kilo giriniz!")
                            }
                           }else {
                               println("Geçerli bir kullanıcı adı giriniz!")
                        }
                    }
                    2 ->{
                        println("Kilosu güncellenecek kullanıcı adı:")
                        val ad = readLine()
                        if (ad!= null && KiloTakip.containsKey(ad)){
                            println("$ad yeni kilosu:")
                            val yeniKilo = readLine()?.toDoubleOrNull()
                            if (yeniKilo != null && yeniKilo > 0){
                                KiloTakip[ad] = yeniKilo
                                println("$ad kullanıcısının kilosu başarıyla güncellendi.")
                                 }else{
                                     println("Geçerli bir kilo giriniz!")
                            }
                          }else{
                              println("Kullanıcı adı geçerli değil!")
                        }
                    }
                    3 -> {
                        println("kilosunu görmek istediğiniz kullanıcı adı:")
                        val ad = readLine()
                        if (ad != null && KiloTakip.containsKey(ad)){
                            println("$ad'in kilosu ${KiloTakip[ad]} kg'dır.")
                        }else{
                            println("Kullanıcı Bulunamadı!")
                        }
                    }
                    4 ->{
                        if (KiloTakip.isNotEmpty()){
                            println("Tüm Kullanıcılar ve Kiloları:")
                            for ((ad,kilo) in KiloTakip){
                                println("$ad: $kilo Kg")
                            }
                        }else{
                            println("Henüz eklenmiş bir kullanıcı yok.")
                        }
                    }
                    5 ->{
                        println("Sistemden Çıkış yapılıyor. iyi günler!")
                        break
                    }
                    else -> println("Geçerli bir seçim yapınız!")
                }
            }
        }
    }
}