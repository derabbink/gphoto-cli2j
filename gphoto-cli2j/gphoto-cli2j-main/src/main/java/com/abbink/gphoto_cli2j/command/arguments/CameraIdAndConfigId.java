package com.abbink.gphoto_cli2j.command.arguments;

import com.abbink.gphoto_cli2j.command.result.ConfigId;

/** 
 * A combination of {@link com.abbink.gphoto_cli2j.command.arguments.CameraId} and {@link com.abbink.gphoto_cli2j.command.result.ConfigId}
 */
public class CameraIdAndConfigId {
	
	public static CameraIdAndConfigId fromCameraIdAndConfigId(CameraId cameraId, ConfigId configId) {
		return new CameraIdAndConfigId(cameraId, configId);
	}
	
	private CameraId cameraId;
	private ConfigId configId;
	
	private CameraIdAndConfigId(CameraId cameraId, ConfigId configId) {
		setCameraId(cameraId);
		setConfigId(configId);
	}

	public CameraId getCameraId() {
		return cameraId;
	}

	public void setCameraId(CameraId cameraId) {
		this.cameraId = cameraId;
	}

	public ConfigId getConfigId() {
		return configId;
	}

	public void setConfigId(ConfigId configId) {
		this.configId = configId;
	}
}
