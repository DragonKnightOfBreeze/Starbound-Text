package icu.windea.starboundText

import com.intellij.DynamicBundle
import org.jetbrains.annotations.*

@NonNls
private const val BUNDLE = "messages.StarboundTextBundle"

object StarboundTextBundle: DynamicBundle(BUNDLE) {
    @Nls
    @JvmStatic
    fun message(@NonNls @PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
        return getMessage(key, *params)
    }

    @Nls
    @JvmStatic
    fun lazyMessage(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): () -> String {
        return { getMessage(key, *params) }
    }
}
