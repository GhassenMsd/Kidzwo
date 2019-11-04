package com.Esprit.sim.kidzwo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Esprit.sim.kidzwo.R;
import com.github.barteksc.pdfviewer.PDFView;

public class BookPdf extends AppCompatActivity {
    PDFView pdfbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pdf);
        Intent intent = getIntent();
        String res = intent.getExtras().getString("res");
        pdfbook = findViewById(R.id.pdfbook);
        pdfbook.fromAsset(res).load();
    }
}
