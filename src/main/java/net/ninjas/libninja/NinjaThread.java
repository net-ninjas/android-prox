package net.ninjas.libninja;

import net.ninjas.device.Messages;

/**
 * Created by ohad on 25-Jul-18.
 */

class NinjaThread extends Thread {
    boolean stopped = false;

    @Override
    public void run() {
        byte[] ser = new byte[0];
        try {
            Messages.register register = Messages.register.newBuilder()
                    .setSellerCode(ninja.resellerId)
                    .setId(ninja.deviceId)
                    .addCapabilities(Messages.register.Capability.newBuilder().
                            setType(Messages.register.CapabilityType.URL_RETRIEVE).build())
                    .build();
            ser = register.toByteArray();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        while (!stopped) {
            System.out.println("ninja thread is running " + ser.length);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
