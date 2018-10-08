package society.doscon.com.doscon;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

/**
 * Created by stpl on 24-10-2017.
 */
public class SignUpAPICall extends AsyncTask<JSONObject, Void, String> {
    int isPostOrGet;
    private String TAG;
    private CallBackToClass fragment;
    private String URL;
    private Context context;
    private ProgressDialog ringProgressDialog;

    public SignUpAPICall(String url, int isPostOrGet, String tag, CallBackToClass fragment, Context context) {
        this.TAG = tag;
        this.fragment = fragment;
        this.URL = url;
        this.context = context;
        this.isPostOrGet = isPostOrGet;
        if (!StaticFuc.INSTANCE.isNetworkConnected(context))
            return;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ringProgressDialog = StaticFuc.INSTANCE.getProgressDialog(context);
    }

    @Override
    protected String doInBackground(JSONObject... params) {
        return isPostOrGet == 0 ? HttpConnection.Companion.performPostCall(URL, params[0], context) : (isPostOrGet == 1 ? HttpConnection.Companion.performGetCall(URL, context) : HttpConnection.Companion.performDeleteCall(URL, context));
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ringProgressDialog.dismiss();
        if (s.equalsIgnoreCase("401"))
            System.out.println("");
        else
            fragment.returnDataToClass(TAG, s);
    }

    public interface CallBackToClass {
        public void returnDataToClass(String tag, String data);
    }
}
