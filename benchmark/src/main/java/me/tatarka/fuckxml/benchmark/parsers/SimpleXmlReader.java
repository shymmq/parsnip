package me.tatarka.fuckxml.benchmark.parsers;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;
import org.simpleframework.xml.transform.Transform;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import me.tatarka.fuckxml.benchmark.TweetsReader;
import me.tatarka.fuckxml.benchmark.model.feed;

public class SimpleXmlReader implements TweetsReader {
    private Serializer serializer;
    
    public SimpleXmlReader() {
        RegistryMatcher m = new RegistryMatcher();
        m.bind(Date.class, new DateFormatTransformer());
        serializer = new Persister(m);
    }

    @Override
    public feed read(InputStream stream) throws Exception {
        return serializer.read(feed.class, stream);
    }

    static class DateFormatTransformer implements Transform<Date> {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

        @Override
        public Date read(String value) throws Exception {
            return dateFormat.parse(value);
        }

        @Override
        public String write(Date value) throws Exception {
            return dateFormat.format(value);
        }
    }
}
