package society.doscon.com.doscon

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by Rajan Gupta on 28-08-2018.
 */
class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.left = space
        outRect?.right = space
        outRect?.bottom = space
        outRect?.top = space
        // Add top margin only for the first item to avoid double space between items
       /* if (parent?.getChildLayoutPosition(view) == 0) {
            outRect?.top = space
        }*/
//        else {
//            outRect?.top = 0
//        }
    }
    /*  @Override
      fun getItemOffsets(outRect: Rect, view: View,
                         parent: RecyclerView, state: RecyclerView.State) {
          outRect.left = space
          outRect.right = space
          outRect.bottom = space

          // Add top margin only for the first item to avoid double space between items
          if (parent.getChildLayoutPosition(view) == 0) {
              outRect.top = space
          } else {
              outRect.top = 0
          }
      }*/
}