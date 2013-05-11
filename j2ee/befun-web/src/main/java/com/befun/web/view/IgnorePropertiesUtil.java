package com.befun.web.view;

import java.util.ArrayList;
import java.util.List;

public class IgnorePropertiesUtil {

    public static String[] generateIgnoredProps(String[] ignoredProperties, List<String> externalIgnoredProperties) {
        List<String> ignoredProps = new ArrayList<String>();
        if (ignoredProperties != null) {
            for (String p : ignoredProperties) {
                ignoredProps.add(p);
            }
        }
        if (externalIgnoredProperties != null) {
            ignoredProps.addAll(externalIgnoredProperties);
        }
        return ignoredProps.toArray(new String[] {});
    }

    public static String[] generateIgnoredProps(String[] ignoredProperties, String[] externalIgnoredProperties) {
        List<String> ignoredProps = new ArrayList<String>();
        if (ignoredProperties != null) {
            for (String p : ignoredProperties) {
                ignoredProps.add(p);
            }
        }
        if (externalIgnoredProperties != null) {
            for (String p : externalIgnoredProperties) {
                ignoredProps.add(p);
            }
        }
        return ignoredProps.toArray(new String[] {});
    }
}
