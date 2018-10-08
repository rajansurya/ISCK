package society.doscon.com.doscon

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Created by stpl on 06-Jun-16.
 */
class HttpConnection {


    companion object {

        private val LOGCAT_TAG = HttpConnection::class.java.simpleName

        fun performPostCall(requestURL: String, postDataParams: JSONObject, context: Context): String {
            Log.d(LOGCAT_TAG, "RequestUrl: " + requestURL.toString())
            Log.d(LOGCAT_TAG, "Json: " + postDataParams.toString())
            val url: URL
            var response = ""
            try {
                url = URL(requestURL)

                val conn = url.openConnection() as HttpURLConnection
                conn.connectTimeout = 30000
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json")
                conn.setRequestProperty("Tokenkey", "YWlvczE5MzA6YWlvczE5MzBhaW9z")
//                conn.setRequestProperty("Authorization", Auth_Credential.getAuthToken(context))
//                conn.setRequestProperty("X-Client-Ip", Static_Function.getIPAddress(true))
                conn.doOutput = true

                val os = conn.outputStream
                val writer = BufferedWriter(OutputStreamWriter(os))
                writer.write(postDataParams.toString())

                writer.flush()
                writer.close()
                os.close()

                val responseCode = conn.responseCode
                Log.d(LOGCAT_TAG, "responseCode:" + responseCode)
                if (responseCode == HttpsURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                    var inputLine: String?
                    val br: BufferedReader = BufferedReader(InputStreamReader(conn.inputStream))
//                    response = br.readLine()
                    /* while (line=br?.readLine() != null) {
                         response += line
                     }*/
                    inputLine = `br`?.readLine()
                    while (inputLine != null) {
                        response += inputLine
                        inputLine = `br`?.readLine()
                    }
                    br.close()
                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    response = "401"
                    return response
                } else {// if (responseCode == HttpsURLConnection.HTTP_BAD_REQUEST)
                    val `in` = BufferedReader(InputStreamReader(conn.errorStream))
                    var inputLine: String?
                    inputLine = `in`?.readLine()
                    while (inputLine != null) {
                        response += inputLine
                        inputLine = `in`?.readLine()
                    }
                    `in`?.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Log.d(LOGCAT_TAG, "Response: " + response)
            return response
        }

        fun performGetCall(requestURL: String, context: Context): String {
            Log.d(LOGCAT_TAG, "RequestUrl: " + requestURL.toString())
            val url: URL
            var response = ""
            try {
                url = URL(requestURL)

                val conn = url.openConnection() as HttpURLConnection
                //  conn.setReadTimeout(30000);
                conn.connectTimeout = 30000
                conn.requestMethod = "GET"
//                conn.setRequestProperty("X-device-token", Auth_Credential.getXDeviceToken(context))
//                conn.setRequestProperty("Authorization", Auth_Credential.getAuthToken(context))
//                conn.setRequestProperty("X-Client-Ip", Static_Function.getIPAddress(true))
                conn.setRequestProperty("sales-executive-login", "1")
                conn.connect()

                val responseCode = conn.responseCode
                Log.d(LOGCAT_TAG, "responseCode:" + responseCode)

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    var inputLine: String?
                    val br = BufferedReader(InputStreamReader(conn.inputStream))
                    inputLine = `br`?.readLine()
                    while (inputLine != null) {
                        response += inputLine
                        inputLine = `br`?.readLine()
                    }
                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    response = "401"
                    return response
                } else {
                    val `in` = BufferedReader(InputStreamReader(conn.errorStream))
                    var inputLine: String?
                    inputLine = `in`?.readLine()
                    while (inputLine != null) {
                        response += inputLine
                        inputLine = `in`?.readLine()
                    }
                    `in`.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Log.d(LOGCAT_TAG, "Response: " + response)
            return response
        }

        fun performPutCall(requestURL: String, postDataParams: JSONObject, context: Context): String {
            Log.d(LOGCAT_TAG, "RequestUrl: " + requestURL.toString())
            Log.d(LOGCAT_TAG, "Json: " + postDataParams.toString())
            val url: URL
            var response = ""
            try {
                url = URL(requestURL)

                val conn = url.openConnection() as HttpURLConnection
                conn.connectTimeout = 30000
                conn.requestMethod = "PUT"
                conn.setRequestProperty("Content-Type", "application/json")
//                conn.setRequestProperty("X-device-token", Auth_Credential.getXDeviceToken(context))
//                conn.setRequestProperty("Authorization", Auth_Credential.getAuthToken(context))
                conn.doOutput = true

                val os = conn.outputStream
                val writer = BufferedWriter(OutputStreamWriter(os))
                writer.write(postDataParams.toString())

                writer.flush()
                writer.close()
                os.close()

                val responseCode = conn.responseCode
                Log.d(LOGCAT_TAG, "responseCode:" + responseCode)
                if (responseCode == HttpsURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                    var line: String
                    val br = BufferedReader(InputStreamReader(conn.inputStream))
                    line = br.readLine()
                    while (line != null) {
                        response += line
                    }
                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    response = "401"
                    return response
                } else {// if (responseCode == HttpsURLConnection.HTTP_BAD_REQUEST)
                    val `in` = BufferedReader(
                            InputStreamReader(conn.errorStream))
                    var inputLine: String
                    inputLine = `in`.readLine()
                    while (inputLine != null) {
                        response += inputLine
                    }
                    `in`.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Log.d(LOGCAT_TAG, "Response: " + response)
            return response
        }

        fun performDeleteCall(requestURL: String, context: Context): String {

            Log.d(LOGCAT_TAG, "RequestUrl: " + requestURL.toString())
            val url: URL
            var response = ""
            try {
                url = URL(requestURL)

                val conn = url.openConnection() as HttpURLConnection
                //  conn.setReadTimeout(30000);
                conn.connectTimeout = 30000
                conn.doOutput = true
                //            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.requestMethod = "DELETE"
//                conn.setRequestProperty("X-device-token", Auth_Credential.getXDeviceToken(context))
//                conn.setRequestProperty("Authorization", Auth_Credential.getAuthToken(context))
                conn.connect()

                val responseCode = conn.responseCode
                Log.d(LOGCAT_TAG, "responseCode:" + responseCode)

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    var line: String
                    val br = BufferedReader(InputStreamReader(conn.inputStream))
                    line = br.readLine()
                    while (line != null) {
                        response += line
                    }
                } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    response = "401"
                    return response
                } else {
                    val `in` = BufferedReader(InputStreamReader(conn.errorStream))
                    var inputLine: String
                    inputLine = `in`.readLine()
                    while (inputLine != null) {
                        response += inputLine
                    }
                    `in`.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Log.d(LOGCAT_TAG, "Response: " + response)
            return response

        }

    }
}
