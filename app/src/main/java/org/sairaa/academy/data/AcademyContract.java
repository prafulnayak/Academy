package org.sairaa.academy.data;

import android.net.Uri;

/**
 * Created by praful on 12/25/2017.
 */

public class AcademyContract {

    private static final String CONTENT_AUTHORITY = "org.sairaa.academy";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_STUDENT = "student";

    //public static final String PATH_IMAGE = "files";

    private AcademyContract(){

    }


}
