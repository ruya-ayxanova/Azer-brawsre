import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView

class AzerBrowserUiFactory44 {

    fun createStatusView(context: Context): TextView {
        return TextView(context).apply {
            text = "Azer Browser"
            textSize = 14f
        }
    }

    fun createContainer(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
        }
    }
}
