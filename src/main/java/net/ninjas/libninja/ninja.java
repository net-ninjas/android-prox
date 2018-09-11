package net.ninjas.libninja;

public class ninja {
    public static long minTime = 0;
    public static long maxTime = Long.MAX_VALUE;
    public static long nextWorkTime = 0;

    static String resellerId = null;
    static long deviceId;

    private static String[] _capabilities = {"url_retrieve"};
    static String[] allowed_capabilities = _capabilities;
    public static String[] getAvailableCapabilities() {
        return _capabilities;
    }

    private static NinjaThread _thread;

    public static void stop() {
        if(_thread == null)
            return;
        _thread.stopped = true;
    }

    public static boolean start(String reseller, long device){
        if(resellerId != null && !reseller.equals(resellerId)) {
            System.out.println("netninja: are you trying to put a new ID?");
        }
        resellerId = reseller;
        deviceId = device;
        try {
            if(_thread != null) {
                stop();
            }
            _thread = new NinjaThread();
            _thread.start();
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean isRunning() {
        if(_thread == null)
            return false;
        return _thread.isAlive();
    }

    public static boolean removeCapabality() {

        return true;
    }
}
