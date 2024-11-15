package fr.w3blog.zpl.constant;

/**
 * Command to determine the type of paper used.
 * 
 * ZPL command : ^MN
 * 
 * @author ltrudu
 * 
 */
public enum ZebraPaperType {

	CONTINUOUS("N"),
	NON_CONTINUOUS_WEB_SENSING("W"),
	MARK_SENSING("M");

	private final String desiredMode;
	private final int blackMarkOffsetInDots; // 保留字段，但所有实例中都是0

	ZebraPaperType(String desiredMode) {
		this.desiredMode = desiredMode;
		this.blackMarkOffsetInDots = 0; // 所有实例中都是0
	}

	ZebraPaperType(String desiredMode, int blackMarkOffsetInDots) {
		this.desiredMode = desiredMode;
		this.blackMarkOffsetInDots = blackMarkOffsetInDots;
	}

	/**
	 * @return the desiredMode
	 */
	public String getDesiredMode() {
		return desiredMode;
	}

	/**
	 * @return the blackMarkOffsetInDots
	 */
	public int getBlackMarkOffsetInDots() {
		return blackMarkOffsetInDots;
	}

	/**
	 * Function which returns the ^MN command
	 *
	 * @return the ZPL code for the paper type
	 */
	public String getZplCode() {
		if ("M".equals(desiredMode)) {
			return "^MN" + desiredMode + "," + blackMarkOffsetInDots + "\n";
		}
		return "^MN" + desiredMode + "\n";
	}

	/**
	 * Gets the ZebraPaperType enum from a string value.
	 *
	 * @param name the string value to match
	 * @return the corresponding ZebraPaperType
	 * @throws IllegalArgumentException if the name does not match any enum constant
	 */
	public static ZebraPaperType getPaperType(String name) {
		for (ZebraPaperType type : values()) {
			if (type.name().equals(name)) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching constant for " + name);
	}
}