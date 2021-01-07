import com.plusmobileapps.composeui.App
import androidx.compose.desktop.Window
import com.plusmobileapps.sharedcode.DependencyInjection

fun main() = Window {
    App(DependencyInjection.todoRepository)
}