package com.abbink.gphoto_cli2j.command.arguments;

/**
 * Identifies a camera by port an name
 */
public class CameraId {
	private String port;
	private String cameraName;
	
	public CameraId(String port, String cameraName) {
		this.port = port;
		this.cameraName = cameraName;
	}
	
	public String getPort() {
		return port;
	}
	
	public String getCameraName() {
		return cameraName;
	}
}
