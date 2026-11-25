package com.example.data

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import com.example.model.TradeCourse
import java.io.File
import java.io.FileOutputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PdfGuideExporter {

    suspend fun generateTradeGuidePdf(context: Context, trade: TradeCourse): Result<File> =
        withContext(Dispatchers.IO) {
            runCatching {
                val guidesDir = File(context.filesDir, "guides").apply { mkdirs() }
                val outputFile = File(guidesDir, trade.pdfGuideTitle)

                val document = PdfDocument()
                val pageWidth = 595
                val pageHeight = 842
                val margin = 44f
                val maxLineWidth = pageWidth - (margin * 2)

                val titlePaint = Paint().apply {
                    color = Color.parseColor("#0F172A")
                    textSize = 22f
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                }
                val accentPaint = Paint().apply {
                    color = Color.parseColor("#D97706")
                    textSize = 12f
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                }
                val headingPaint = Paint().apply {
                    color = Color.parseColor("#0F172A")
                    textSize = 15f
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                }
                val bodyPaint = Paint().apply {
                    color = Color.parseColor("#334155")
                    textSize = 11.5f
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
                val dividerPaint = Paint().apply {
                    color = Color.parseColor("#F59E0B")
                    strokeWidth = 3f
                }

                var pageNumber = 1
                var page = document.startPage(
                    PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
                )
                var canvas = page.canvas
                var y = 60f

                fun ensureSpace(neededHeight: Float) {
                    if (y + neededHeight > pageHeight - 50f) {
                        document.finishPage(page)
                        pageNumber += 1
                        page = document.startPage(
                            PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
                        )
                        canvas = page.canvas
                        y = 56f
                    }
                }

                fun drawWrappedText(text: String, paint: Paint, lineHeight: Float) {
                    val words = text.split(" ")
                    var currentLine = StringBuilder()
                    for (word in words) {
                        val candidate = if (currentLine.isEmpty()) word else "$currentLine $word"
                        if (paint.measureText(candidate) <= maxLineWidth) {
                            currentLine = StringBuilder(candidate)
                        } else {
                            ensureSpace(lineHeight)
                            canvas.drawText(currentLine.toString(), margin, y, paint)
                            y += lineHeight
                            currentLine = StringBuilder(word)
                        }
                    }
                    if (currentLine.isNotEmpty()) {
                        ensureSpace(lineHeight)
                        canvas.drawText(currentLine.toString(), margin, y, paint)
                        y += lineHeight
                    }
                }

                canvas.drawText("APRANN METYE - GID PRATIK GRATIS", margin, y, accentPaint)
                y += 26f
                drawWrappedText(trade.title, titlePaint, 28f)
                y += 4f
                canvas.drawLine(margin, y, pageWidth - margin, y, dividerPaint)
                y += 20f
                drawWrappedText(trade.description, bodyPaint, 17f)
                y += 16f

                for (module in trade.modules) {
                    ensureSpace(44f)
                    drawWrappedText(module.title, headingPaint, 20f)
                    y += 4f
                    drawWrappedText(module.summary, bodyPaint, 16f)
                    y += 6f
                    for (section in module.sections) {
                        ensureSpace(32f)
                        drawWrappedText("• ${section.heading}", accentPaint, 17f)
                        drawWrappedText(section.body, bodyPaint, 16f)
                        section.practicalTip?.let { tip ->
                            drawWrappedText("Konsèy Pratik: $tip", bodyPaint, 16f)
                        }
                        y += 6f
                    }
                    y += 12f
                }

                document.finishPage(page)
                FileOutputStream(outputFile).use { out ->
                    document.writeTo(out)
                }
                document.close()
                outputFile
            }
        }
}
