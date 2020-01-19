package exercise.z_learning;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Texting {

    public static void main(String[] args) throws IOException {
        String accountID = "CI00205890";
        String email = "lamdoanshopping@gmail.com";
        String password = "gG0kJpw6";
        String recipient = "7088210281";
//        String recipient = "6309269308";
        String message = "baby smells like shit";

        SendSMS(accountID, email, password, recipient, message, null);
    }

    public static int SendSMS(String AccountID, String Email, String Password,
                              String Recipient, String Message, StringBuffer Response) throws IOException {
        String RequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

        String Data = ("AccountId=" + URLEncoder.encode(AccountID, "UTF-8"));
        Data += ("&Email=" + URLEncoder.encode(Email, "UTF-8"));
        Data += ("&Password=" + URLEncoder.encode(Password, "UTF-8"));
        Data += ("&Recipient=" + URLEncoder.encode(Recipient, "UTF-8"));
        Data += ("&Message=" + URLEncoder.encode(Message, "UTF-8"));

        int Result = -1;
        URL Address = new URL(RequestURL);

        HttpURLConnection Connection = (HttpURLConnection) Address.openConnection();
        Connection.setRequestMethod("POST");
        Connection.setDoInput(true);
        Connection.setDoOutput(true);

        DataOutputStream Output;
        Output = new DataOutputStream(Connection.getOutputStream());
        Output.writeBytes(Data);
        Output.flush();
        Output.close();

//        BufferedReader Input = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
//        StringBuffer ResponseBuffer = new StringBuffer();
//        String InputLine;
//
//        while ((InputLine = Input.readLine()) != null)
//        {
//            ResponseBuffer = ResponseBuffer.append(InputLine);
//            ResponseBuffer = ResponseBuffer.append("\n\n\n");
//        }
//
//        Response.replace(0, 0, ResponseBuffer.toString());
//        String ResultCode = Response.substring(0, 4);
//        Result = Integer.parseInt(ResultCode);
//        Input.close();
//
//        return Result;
        return 0;
    }
}
