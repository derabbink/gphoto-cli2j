package com.abbink.gphoto_cli2j.command.arguments;

/**
 * Identifies a camera by port an name
 */
public class CameraId {
	private String port;
	private String cameraName;
	
	public CameraId(String port, String cameraName) {
		setPort(port);
		setCameraName(cameraName);
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getCameraName() {
		return cameraName;
	}
	
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
}
