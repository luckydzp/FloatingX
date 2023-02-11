package com.petterp.floatingx.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.petterp.floatingx.FloatingX
import com.petterp.floatingx.app.kotlin.CustomKtApplication

/**
 * 多浮窗示例
 *
 * @author petterp
 */
class MultipleFxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createLinearLayoutToParent {
            addNestedScrollView {
                addLinearLayout {
                    addItemView("显示全局悬浮窗-tag1") {
                        if (!FloatingX.isInstalled(TAG_1)) {
                            CustomKtApplication.installTag1(application)
                        }
                        FloatingX.control(TAG_1).show()
                    }
                    addItemView("显示全局悬浮窗-tag2") {
                        if (!FloatingX.isInstalled(TAG_2)) {
                            CustomKtApplication.installTag2(application)
                        }
                        FloatingX.control(TAG_2).show()
                    }
                    addItemView("隐藏全局悬浮窗-tag1") {
                        FloatingX.control(TAG_1).hide()
                    }
                    addItemView("隐藏全局悬浮窗-tag2") {
                        FloatingX.control(TAG_2).hide()
                    }
                    addItemView("卸载所有全局浮窗") {
                        FloatingX.uninstallAll()
                    }
                }
            }
        }
    }

    companion object {
        const val TAG_1 = "tag1"
        const val TAG_2 = "tag2"
    }
}
