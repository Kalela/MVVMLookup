package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val battery = Battery();
        val memoryCard = MemoryCard();
        val serviceProvider = ServiceProvider();
        val simCard = SIMCard(serviceProvider);
        val smartPhone = SmartPhone(battery, simCard, memoryCard)
        smartPhone.makeACallWithRecording()

        //Types of dependency injection
        // 1. Constructor injection(self explanatory)
        // 2. Method injection (using setters)
        // 3. Field injection (using public fields in a class)
    }
}
