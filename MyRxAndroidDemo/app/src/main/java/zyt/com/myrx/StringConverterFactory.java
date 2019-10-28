package zyt.com.myrx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;

public class StringConverterFactory extends Factory {

    public static StringConverterFactory create() {
        return new StringConverterFactory();
    }


    final class ConfigurationServiceConverter implements Converter<ResponseBody, String> {

        @Override
        public String convert(ResponseBody value) throws IOException {
            BufferedReader r = new BufferedReader(new InputStreamReader(value.byteStream()));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            return total.toString();
        }
    }

}
