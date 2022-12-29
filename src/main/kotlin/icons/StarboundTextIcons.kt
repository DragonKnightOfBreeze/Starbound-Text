package icons

import com.intellij.icons.AllIcons
import com.intellij.ui.IconManager
import javax.swing.Icon

object StarboundTextIcons {
    @JvmField val StarboundTextFile = AllIcons.FileTypes.Text

    @JvmStatic fun loadIcon(path: String): Icon {
        return IconManager.getInstance().getIcon(path, StarboundTextIcons::class.java)
    }
}