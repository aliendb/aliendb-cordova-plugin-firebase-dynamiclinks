package aliendb.cordova.firebase;

import android.content.Intent;

import CordovaMethod;
import ReflectiveCordovaPlugin;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;


public class FirebaseDynamicLinksPlugin extends ReflectiveCordovaPlugin {
    private static final String TAG = "FirebaseDynamicLinks";

    private CallbackContext dynamicLinkCallback;

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (this.dynamicLinkCallback != null) {
            respondWithDynamicLink(intent);
        }
    }

    @CordovaMethod
    private void onDynamicLink(CallbackContext callbackContext) {
        this.dynamicLinkCallback = callbackContext;

        respondWithDynamicLink(cordova.getActivity().getIntent());
    }

    private void respondWithDynamicLink(Intent intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent)
            .continueWith(new Continuation<PendingDynamicLinkData, JSONObject>() {
                @Override
                public JSONObject then(Task<PendingDynamicLinkData> task) throws JSONException {
                    PendingDynamicLinkData data = task.getResult();

                    JSONObject result = new JSONObject();
                    result.put("deepLink", data.getLink());
                    result.put("clickTimestamp", data.getClickTimestamp());
                    result.put("minimumAppVersion", data.getMinimumAppVersion());

                    if (dynamicLinkCallback != null) {
                        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
                        pluginResult.setKeepCallback(true);
                        dynamicLinkCallback.sendPluginResult(pluginResult);
                    }

                    return result;
                }
            });
    }
}
