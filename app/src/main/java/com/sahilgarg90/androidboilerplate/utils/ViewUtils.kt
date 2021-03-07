package com.sahilgarg90.androidboilerplate.utils

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Resources
import android.graphics.BlurMaskFilter
import android.os.Build
import android.text.InputFilter
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.view.doOnPreDraw
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Sahil Garg on 07-03-2021.
 */

class ViewUtils {

    companion object {

        fun hideKeyboard(context: Context) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            if (context is Activity) {
                var view = context.currentFocus
                if (view == null) {
                    view = View(context)
                }
                imm!!.hideSoftInputFromWindow(
                    view.windowToken,
                    0
                )
            }
        }

        fun hideKeyboard(view: View) {
            val imm =
                view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun hideKeyboard(activity: Activity) {
            val view = activity.findViewById<View>(android.R.id.content)
            if (view != null) {
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        fun showShortToast(context: Context, text: String?) {
            if (text.isNullOrEmpty()) return
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

        fun showLongToast(context: Context, text: String?) {
            if (text.isNullOrEmpty()) return
            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        }

        fun showShortSnack(view: View, text: String?, anchorView: View? = null) {
            if (text.isNullOrEmpty()) return
            val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
            anchorView?.let {
                snackBar.setAnchorView(anchorView)
            }
            snackBar.show()
        }

        fun showLongSnack(view: View, text: String?, anchorView: View? = null): Snackbar? {
            if (text.isNullOrEmpty()) return null
            val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            anchorView?.let {
                snackBar.setAnchorView(anchorView)
            }
            snackBar.show()
            return snackBar
        }

        fun showActionSnack(view: View, text: String?, action: String, listener: SnackListener) {
            if (text.isNullOrEmpty()) return
            val snack = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
            snack.setAction(action) {
                listener.onActionPressed()
                snack.dismiss()
            }
            snack.addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    listener.onDismissed()
                }
            })
            snack.show()
        }

        fun showIndefiniteActionSnack(
            view: View,
            text: String?,
            action: String,
            listener: () -> Unit
        ) {
            if (text.isNullOrEmpty()) return
            val snack = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
            snack.setAction(action) {
                listener()
                snack.dismiss()
            }
            snack.show()
        }

        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun spToPx(sp: Int): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp.toFloat(),
                Resources.getSystem().displayMetrics
            )
        }

        fun showKeyboard(context: Context, editText: EditText) {
            editText.requestFocus()
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        }

        fun showKeyboard(context: Context) {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }

        fun showSomethingWentWrongToast(context: Context) {
            showShortToast(context, "Something went wrong!")
        }

        fun copyToClipboard(context: Context, data: String) {
            val clipboard: ClipboardManager? =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText("data", data)
            clipboard?.setPrimaryClip(clip)
            showLongToast(context, "Data copied!")
        }

        fun copyToClipboard(
            context: Context, text: String?, successMessage: String, labelText: String
        ) {
            val clipboard: ClipboardManager? =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText(labelText, text)
            clipboard?.setPrimaryClip(clip)
            showLongToast(context, successMessage)
        }
    }
}

fun TextView.setMaxLinesToEllipsize() = doOnPreDraw {
    val numberOfCompletelyVisibleLines =
        (measuredHeight - paddingTop - paddingBottom) / lineHeight
    maxLines = numberOfCompletelyVisibleLines
}

fun TextView.blurText() {
    val radius = textSize / 4
    val filter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    paint.maskFilter = filter
}

fun EditText.setMaxLength(maxLength: Int) {
    if (maxLength < 0) return
    this.filters = arrayOf(InputFilter.LengthFilter(maxLength))
}

fun EditText.setCursorDrawable(@DrawableRes drawableId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        this.setTextCursorDrawable(drawableId)
    } else {
        try {
            val field = TextView::class.java.getDeclaredField("mCursorDrawableRes")
            field.isAccessible = true
            field.set(this, drawableId)
        } catch (ignored: Exception) {
        }
    }
}

fun EditText.placeCursorToEnd() {
    this.setSelection(this.text.length)
}

interface SnackListener {
    fun onDismissed()
    fun onActionPressed()
}