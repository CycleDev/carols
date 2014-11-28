package nao.cycledev.carols.repository;

import nao.cycledev.carols.model.Carol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class CarolXmlRepository extends CarolRepository {

    private String xmlstr;

    public CarolXmlRepository(String xmlstr) {
        this.xmlstr = xmlstr;
    }

    @Override
    public void loadCarols() {

        XmlPullParserFactory factory ;
        XmlPullParser parser;
        Carol carol = null;
        String text = "";
        String tagname = "";

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlstr));

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("carol")) {
                            // create a new instance of employee
                            carol = new Carol();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equalsIgnoreCase("carol")) {
                            addCarol(carol);
                        } else if (tagname.equalsIgnoreCase("id")) {
                            carol.setId(Long.parseLong(text));
                        } else if (tagname.equalsIgnoreCase("title")) {
                            carol.setTitle(text);
                        } else if (tagname.equalsIgnoreCase("text")) {
                            carol.setText(text);
                        } else if (tagname.equalsIgnoreCase("info")) {
                            carol.setInfo(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
