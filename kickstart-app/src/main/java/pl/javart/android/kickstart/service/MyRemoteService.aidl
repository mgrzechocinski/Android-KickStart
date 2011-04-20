package pl.javart.android.kickstart.service;
/**
 * @author: mgrzechocinski@javart.eu
 * @since: 20/04/2011
 */
// Declare any non-default types here with import statements
/** Example service interface */
interface MyRemoteService {

    /** Request the process ID of this service, to do evil things with it. */
    int getPid();

    /** Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}

}
