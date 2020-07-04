package team.thegoldenhoe.cameraobscura.common.network;

public enum CameraType {
    VINTAGE("vintage_camera"),
    POLAROID("polaroid_camera"),
    DIGITAL("digital_camera");

	private String textureName;
	public static CameraType[] VALUES = values();

	CameraType(String textureName) {
		this.textureName = textureName;
	}

	public String getTextureName() {
		return this.textureName;
	}
}
