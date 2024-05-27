package com.sc941737.cmmdemo.shared.util

import android.graphics.BitmapFactory
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import java.io.File

@Composable
actual fun rememberOpenPickerAction(onImageSelected:(ImageBitmap) -> Unit): () -> Unit {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            val inputStream = context.contentResolver.openInputStream(uri)
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor?.use { c ->
                val nameIndex = c.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (c.moveToFirst()) {
                    val name = c.getString(nameIndex)
                    inputStream?.let { inputStream ->
                        // create same file with same name
                        val file = File(context.cacheDir, name)
                        val os = file.outputStream()
                        os.use {
                            inputStream.copyTo(it)
                        }
                        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                        onImageSelected(bitmap.asImageBitmap())
                    }
                }
            }
        }
    }
    return {
        launcher.launch(
            PickVisualMediaRequest(
                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
            )
        )
    }
}
