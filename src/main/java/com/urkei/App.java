package com.urkei;

public class App {
    public static void main( String[] args )
    {
    	Device device = new DeviceImpl();
    	boolean started = device.start();
        System.out.println( "Device has started: " + (started?"TRUE":"FALSE"));
    }
}
