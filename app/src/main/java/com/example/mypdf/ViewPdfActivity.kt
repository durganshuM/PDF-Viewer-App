package com.example.mypdf

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

class ViewPdfActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView
    private val PDF_SELECTION_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pdf)
        inIt()
        selectPdfFromStorage()
    }

    private fun selectPdfFromStorage() {
        Toast.makeText(this,"Select PDF File",Toast.LENGTH_SHORT).show()
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.type = "application/pdf"
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browseStorage,"Select PDF File"),PDF_SELECTION_CODE)
    }

    private fun showPdfFromUri(uri: Uri?){
        pdfView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .enableSwipe(true)
            .enableDoubletap(true)
            .load()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PDF_SELECTION_CODE && resultCode == RESULT_OK && data != null){
            val selectedPdf = data.data
            showPdfFromUri(selectedPdf)
        }
    }

    private fun inIt(){
        pdfView = findViewById(R.id.pdfView)
    }
}