package society.doscon.com.doscon

import android.content.Context
import android.support.v7.widget.GridLayoutManager

class CustomGridLayoutManager : GridLayoutManager {
    private var isScrollEnabled = false
    constructor(context: Context, spancount: Int) : super(context, spancount) {

    }

    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically()
    }
}